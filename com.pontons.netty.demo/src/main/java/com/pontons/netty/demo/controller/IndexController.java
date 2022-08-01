package com.pontons.netty.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className IndexController
 * @description TODO
 * @date 2022/8/1
 */
@RestController("sys")
@RequestMapping("sys")
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "hello";
    }
}
