package com.zzz.pontos.beetlsql;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@PropertySource(value = {
        "classpath:application-simple.properties"
}, encoding = "utf-8")
@SpringBootApplication
class BeetlsqlApplicationTests {

    @Test
    void contextLoads() {
    }
    public static void main(String[] args) {
        SpringApplication.run(BeetlsqlApplicationTests.class, args);
    }
}
