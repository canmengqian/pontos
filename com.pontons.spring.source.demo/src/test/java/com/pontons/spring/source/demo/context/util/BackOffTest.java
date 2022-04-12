package com.pontons.spring.source.demo.context.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.BackOffExecution;
import org.springframework.util.backoff.ExponentialBackOff;
import org.springframework.util.backoff.FixedBackOff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.util.Assert.*;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className BackOffTest
 * @description TODO
 * @date 2022/1/17
 */
@Slf4j
public class BackOffTest {
    @Test
    public void testFixedBackOff() {
        long interval = 100;
        long maxAttempts = 10;
        BackOff backOff = new FixedBackOff(interval, maxAttempts);
        BackOffExecution execution = backOff.start();
        for (int i = 1; i <= 10; i++) {
            //每次重试时间是100毫秒
            System.out.println(execution.nextBackOff());
        }
        assertEquals(BackOffExecution.STOP, execution.nextBackOff());
    }

    @Test
    public void testExponentialBackOff() {
        long initialInterval = 100;//初始间隔
        long maxInterval = 5 * 1000L;//最大间隔
        long maxElapsedTime = 50 * 1000L;//最大时间间隔
        double multiplier = 1.5;//递增倍数（即下次间隔是上次的多少倍）
        ExponentialBackOff backOff = new ExponentialBackOff(initialInterval, multiplier);
        backOff.setMaxInterval(maxInterval);
        backOff.setMaxElapsedTime(maxElapsedTime);

        BackOffExecution execution = backOff.start();

        for (int i = 1; i <= 20; i++) {
            System.out.println(execution.nextBackOff());
        }
        assertEquals(BackOffExecution.STOP, execution.nextBackOff());
    }
}
