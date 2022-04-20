package com.pontons.springboot.zookeeper.demo.controller;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className DemoController
 * @description TODO
 * @date 2022/4/20
 */
@RestController
@RequestMapping("zk")
public class DemoController {

    @Resource
    CuratorFramework curatorFramework;

    @GetMapping("/path/query")
    public List<String> queryPath() throws Exception {
        return curatorFramework.getChildren().forPath("/");
    }
}
