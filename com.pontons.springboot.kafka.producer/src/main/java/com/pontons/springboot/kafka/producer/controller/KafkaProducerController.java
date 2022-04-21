package com.pontons.springboot.kafka.producer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
@Slf4j
public class KafkaProducerController {

    @Resource
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/simple/send")
    @ApiOperation(value = "单一消息发送", notes = "单一消息发送")
    public void simpleSend(@RequestParam("m") String msg) {
        kafkaTemplate.setAllowNonTransactional(false);
        ListenableFuture<SendResult<String, String>> rs = kafkaTemplate.send("test", msg);
        log.info("{}", kafkaTemplate.inTransaction() + "");
        log.info("默认的topic:{}", kafkaTemplate.getDefaultTopic());
        log.info("tid:{}", kafkaTemplate.getTransactionIdPrefix());
        log.info("{}", rs.isDone() + "");
        rs.addCallback(s -> {
            log.info("发送成功");
        }, f -> {
            log.info("发送失败");
        });

    }

    @GetMapping("/simple/send/future")
    @ApiOperation(value = "单一消息发送", notes = "单一消息发送")
    public void simpleSendFuture(@RequestParam("m") String msg) throws ExecutionException, InterruptedException {
        kafkaTemplate.setAllowNonTransactional(false);
        Future<RecordMetadata> rs = kafkaTemplate.getProducerFactory().createProducer().send(new ProducerRecord<>("test", "k", "v"));
        RecordMetadata metadata = rs.get();
        log.info("{}", metadata.toString());
    }


}
