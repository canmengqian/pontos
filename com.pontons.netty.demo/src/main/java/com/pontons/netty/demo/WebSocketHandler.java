package com.pontons.netty.demo;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.pontons.netty.demo.notice.NoticeManager;
import com.pontons.netty.demo.notice.NoticeRequest;
import com.pontons.netty.demo.notice.NoticeResponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.websocketx.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className WebSocketHandler
 * @description 自定义处理器
 * @date 2022/7/28
 */
@Slf4j
@Component
public class WebSocketHandler extends SimpleChannelInboundHandler<Object> {
    /**
     * 信道信息
     */
    private static ConcurrentMap<String, Channel> CHANNEL_MAP = new ConcurrentHashMap();
    /**
     * 用户,信道映射关系
     */
    private static ConcurrentMap<String, String> USER_CHANNEL = new ConcurrentHashMap();

    @Resource
    NoticeManager noticeManager;

    public void setNoticeManager(NoticeManager noticeManager) {
        this.noticeManager = noticeManager;
    }

    public NoticeManager getNoticeManager() {
        return noticeManager;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String token = request.headers().get("token");
            if (CharSequenceUtil.isEmpty(token)) {
                log.warn("token为空,不建立连接信道");
                ctx.disconnect();
                return;
            }
            log.info("------------收到http消息--------------");
            log.info("" + msg);
            handleHttpRequest(ctx, (FullHttpRequest) msg);
            USER_CHANNEL.put(ctx.channel().id().asShortText(), token);
        } else if (msg instanceof WebSocketFrame) {
            if (msg instanceof CloseWebSocketFrame) {
                channelInactive(ctx);
                return;
            }
            //处理websocket客户端的消息
            String message = ((TextWebSocketFrame) msg).text();
            log.info("------------收到消息--------------" + message);
            String cid = ctx.channel().id().asShortText();
            if (!JSONUtil.isJson(message)) {
                // 将消息回复给所有连接
                log.error("接收到的消息非JSON,不作处理");
                ctx.channel().writeAndFlush(new TextWebSocketFrame(USER_CHANNEL.getOrDefault(cid, "未知用户")));
            } else {
                log.info(message);
                String responseJson = "";
                if (USER_CHANNEL.containsKey(cid)) {
                    NoticeRequest request = NoticeRequest.builder().token(USER_CHANNEL.get(cid)).build();
                    responseJson = noticeManager.jsonStr(noticeManager.handle(request));
                }
                if (CharSequenceUtil.isNotEmpty(responseJson)) {
                    ctx.channel().writeAndFlush(new TextWebSocketFrame(responseJson));
                }
            }
        }

    }

    @Scheduled(fixedRate = 5000)
    public void push() {

      //  log.info("开始推送消息");
        PushNoticeService pushNoticeService = new PushNoticeService(this);
        pushNoticeService.push();
    }

    public static class PushNoticeService {
        private ConcurrentMap<String, Channel> channels;
        private ConcurrentMap<String, String> userChannel;

        WebSocketHandler webSocketHandler;

        public PushNoticeService(WebSocketHandler webSocketHandler) {
            this.webSocketHandler = webSocketHandler;
        }

        public synchronized void push() {
            channels = WebSocketHandler.CHANNEL_MAP;
            userChannel = WebSocketHandler.USER_CHANNEL;
            String cid;
            NoticeManager noticeManager = webSocketHandler.getNoticeManager();
            NoticeResponse response;
            String responseJson;
            if (channels != null && !channels.isEmpty()) {
                for (Channel channel : channels.values()) {
                    cid = channel.id().asShortText();
                    if (userChannel.containsKey(cid)) {
                        response = noticeManager.push(null);
                        if (response != null && response.getNotices() != null && !response.getNotices().isEmpty()) {
                            responseJson = JSONUtil.toJsonStr(response);
                            channel.writeAndFlush(new TextWebSocketFrame(responseJson));
                        }
                    }
                }
            }
        }
    }

    /**
     * @author lsc
     * <p> 处理http请求升级</p>
     */
    private void handleHttpRequest(ChannelHandlerContext ctx,
                                   FullHttpRequest req) {
        // 该请求是不是websocket upgrade请求
        if (isWebSocketUpgrade(req)) {
            String ws = "ws://192.168.203.46:8096";
            WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory(ws, null, false);
            WebSocketServerHandshaker handshaker = factory.newHandshaker(req);
            if (handshaker == null) {
                // 请求头不合法, 导致handshaker没创建成功
                WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
            } else {
                // 响应该请求
                handshaker.handshake(ctx.channel(), req);
            }
            return;
        }
    }

    //n1.GET? 2.Upgrade头 包含websocket字符串?
    private boolean isWebSocketUpgrade(FullHttpRequest req) {
        HttpHeaders headers = req.headers();
        return req.method().equals(HttpMethod.GET) && "websocket".equals(headers.get(HttpHeaderNames.UPGRADE));
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //添加连接
        log.debug("客户端加入连接：" + ctx.channel());
        Channel channel = ctx.channel();
        CHANNEL_MAP.put(channel.id().asShortText(), channel);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //断开连接
        log.debug("客户端断开连接：" + ctx.channel());
        Channel channel = ctx.channel();
        CHANNEL_MAP.remove(channel.id().asShortText());
        USER_CHANNEL.remove(channel.id().asShortText());
        channel.disconnect();
    }

}
