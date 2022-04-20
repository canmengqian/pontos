package com.pontons.zookeeper.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className ZooKeeperOperationController
 * @description TODO
 * @date 2022/4/20
 */
@RestController
@RequestMapping("zk")
@Slf4j
public class ZooKeeperOperationController {
    @PostMapping("cura/connect")
    public String connect() {
        return "";
    }

    static CuratorFramework c;

    @Test
    @Before
    public void initClient() throws InterruptedException {
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .connectionTimeoutMs(10000)
                .sessionTimeoutMs(10000)
                .retryPolicy(retry).build();
        client.start();
        client.blockUntilConnected();
        log.info("当前配置:{}", client.getConfig().toString());
        client.getCurrentConfig().getVotingMembers().forEach((k, c) -> {
            log.info("member {}-{}", k, c);
        });
        log.info("namespace:{}", client.getNamespace());
        c = client;

    }

    @Test
    public void test() throws Exception {
        c.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/zln");
        c.close();
    }

    @Test
    public void testQuery() throws Exception {
        c.getChildren().forPath("/").forEach(System.out::println);
    }

    @Test
    public void testDel() throws Exception {
        c.delete().deletingChildrenIfNeeded().forPath("/zln");
        c.getChildren().forPath("/").forEach(System.out::println);
    }


}
