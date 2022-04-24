package com.pontons.springboot.rabbitmq.producer.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className ProducerTest
 * @description TODO
 * @date 2022/4/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProducerTest {

    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendDefDirectMsg() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.send(new Message("hello".getBytes(StandardCharsets.UTF_8)));
            Thread.sleep(1000);
        }

    }
}
