package com.pontons.netty.demo;

import com.pontons.netty.demo.notice.NoticeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className WebSocketConfig
 * @description TODO
 * @date 2022/8/1
 */
@Configuration
public class WebSocketConfig {

    @Autowired
    NoticeManager noticeManager;

    @Autowired
    SocketChannelInitializer socketChannelInitializer;



    @Bean("WebSocketHandler")
    @Order
    @ConditionalOnBean(value = {NoticeManager.class})
    public WebSocketHandler getWebSocketHandler() {
        WebSocketHandler webSocketHandler = new WebSocketHandler();
        webSocketHandler.setNoticeManager(noticeManager);
        return webSocketHandler;
    }

    @Bean("SocketChannelInitializer")
    @Order
    public SocketChannelInitializer getSocketChannelInitializer(@Qualifier("WebSocketHandler") WebSocketHandler webSocketHandler) {
        SocketChannelInitializer socketChannelInitializer = new SocketChannelInitializer();
        socketChannelInitializer.setWebSocketHandler(webSocketHandler);
        return socketChannelInitializer;
    }

    @Bean
    @Order
    public WebSocketServer getWebSocketServer(@Qualifier("SocketChannelInitializer") SocketChannelInitializer socketChannelInitializer) {
        WebSocketServer webSocketServer = new WebSocketServer(socketChannelInitializer);
        webSocketServer.start();
        return webSocketServer;
    }
}
