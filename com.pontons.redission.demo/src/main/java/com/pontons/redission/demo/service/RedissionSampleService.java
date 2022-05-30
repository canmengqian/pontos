package com.pontons.redission.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className RedissionSampleService
 * @description TODO
 * @date 2022/5/30
 */
@Slf4j
public class RedissionSampleService {
    private static Config config = new Config();
    static RedissonClient client;

    @BeforeClass
    public static void init() {
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        client = Redisson.create(config);
    }

    @Test
    public void testOpt() {
        title("字符串插入");
        client.getBucket("Hello").set("world");
        System.out.println(client.getBucket("Hello").get());
    }

    public void title(String title) {
        System.out.println("********************" + title + "********************");
    }


    @AfterClass
    public static void destroy() {
        client.shutdown();
        log.info("redis is shutdown:{}", client.isShutdown());
    }


}
