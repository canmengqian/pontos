package com.pontons.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className HelloWorldTest
 * @description TODO
 * @date 2022/4/29
 */
public class HelloWorldTest {
    @Test
    public void testSend() throws IOException, InterruptedException {
        Channel channel = ClientUtil.createChannel();
        channel.exchangeDeclare(Const.EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true, false, null);
        channel.queueDeclare(Const.QUEUENAME, true, false, false, null);
        channel.queueBind(Const.QUEUENAME, Const.EXCHANGE_NAME, Const.BIND_KEY);
        //
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties();
        channel.basicPublish(Const.EXCHANGE_NAME, Const.BIND_KEY, basicProperties, "Hello word".getBytes(StandardCharsets.UTF_8));
        Thread.sleep(1000);
        Channel channel1 = ClientUtil.createChannel();
        channel1.queueDeclare(Const.QUEUENAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(Const.QUEUENAME, true, deliverCallback, consumerTag -> {
        });
        Thread.currentThread().join(10000);
    }


}

