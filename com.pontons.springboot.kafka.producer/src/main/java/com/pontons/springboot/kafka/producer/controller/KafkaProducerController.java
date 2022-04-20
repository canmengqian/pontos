package com.pontons.springboot.kafka.producer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className KafkaProducerController
 * @description TODO
 * @date 2022/4/19
 */
@RestController
@RequestMapping("/kafka")
@Api("kafka消息发送")
public class KafkaProducerController {
    @GetMapping("/simple/send")
    @ApiOperation(value = "单一消息发送", notes = "单一消息发送")
    public void simpleSend(@RequestParam("m") String msg) {

    }

    @GetMapping("index")
    @ApiOperation(value = "index", notes = "index")
    public Mono<String> index() {
        return Mono.just("index");
    }
}
