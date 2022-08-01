package com.pontons.netty.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className ApplicationConfig
 * @description TODO
 * @date 2022/7/28
 */

public class ApplicationConfig implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        WebSocketServer webSocketServer = new WebSocketServer();
        webSocketServer.init();
    }
}
