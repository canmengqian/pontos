package org.example.git;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.junit.Test;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Demo
 * @description TODO
 * @date 2022/5/27
 */
public class Demo {

    @Test
    public void circuitBreaker() {
        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.ofDefaults();

    }
}
