package com.pontons.spring.source.demo.context.util;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.io.LineNumberReader;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className IdGeneratorTest
 * @description TODO
 * @date 2022/1/17
 */
@Slf4j
public class IdGeneratorTest {
    @Test
    public void  testAlternativeJdkIdGenerator() {
        LineNumberReader nu;
        AlternativeJdkIdGenerator jdkIdGenerator = new AlternativeJdkIdGenerator();
        // TODO 什么是getLeastSignificantBits
        log.info("UUID:{}",jdkIdGenerator.generateId().getLeastSignificantBits());

    }
}
