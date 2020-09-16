package com.zzz.pontos.java.function.defaultfunct;

import org.junit.jupiter.api.Test;

public class ServiceTest {
    @Test
    public int testService() {
        Service service = new Service();
        service.call();

        GranParentService granParentService = (int a ,int b) -> {
            return a-b;
        }
        GranParentService granParentService = (String name) ->{
            System.out.println(name);
        };
    }
}
