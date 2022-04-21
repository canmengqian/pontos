package com.pontons.springboot.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className KafkaConfig
 * @description TODO
 * @date 2022/4/20
 */

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("test",8, (short) 2 );
    }

}
