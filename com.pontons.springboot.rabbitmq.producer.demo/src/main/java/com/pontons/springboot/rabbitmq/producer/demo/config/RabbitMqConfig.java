package com.pontons.springboot.rabbitmq.producer.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className RabbitMqConfig
 * @description TODO
 * @date 2022/4/24
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public TopicExchange getTopicExchage() {
        return new TopicExchange("amq.topic", true, false);
    }

    //2、创建queue
    @Bean
    public Queue getQueue() {
        return new Queue("csdn-follow", true, false, false, null);
    }


    //3、绑定
    @Bean
    public Binding geteBinding(TopicExchange topicExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(topicExchange).with("csdn");
    }
}
