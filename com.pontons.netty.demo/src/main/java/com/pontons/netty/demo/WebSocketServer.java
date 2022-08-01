package com.pontons.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className WebSocketServer
 * @description TODO
 * @date 2022/7/28
 */
@Component
@Slf4j
public class WebSocketServer extends Thread{


    @Resource
   private SocketChannelInitializer socketChannelInitializer;

    public WebSocketServer(SocketChannelInitializer socketChannelInitializer) {
        this.socketChannelInitializer = socketChannelInitializer;
    }

    public WebSocketServer() {
    }


    public void init() {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, work);
            bootstrap.channel(NioServerSocketChannel.class);
            // 自定义处理器
            bootstrap.childHandler(socketChannelInitializer);
            Channel channel = bootstrap.bind(8096).sync().channel();
            log.info("------------webSocket服务器启动成功-----------：" + channel);
            channel.closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("---------运行出错----------：" + e);
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
            log.info("------------websocket服务器已关闭----------------");
        }
    }

    @Override
    public void run() {
        init();
    }
}
