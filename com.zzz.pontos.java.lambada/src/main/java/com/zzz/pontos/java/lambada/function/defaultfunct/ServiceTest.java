package com.zzz.pontos.java.lambada.function.defaultfunct;

import org.junit.jupiter.api.Test;

public class ServiceTest {
    @Test
    public int testService() {
        Service service = new Service();
        service.call();
        return 0;
        /*GranParentService granParentService = (int a, int b) -> {
            return a - b;
        };
        GranParentService granParentService = (String name) -> {
            System.out.println(name);
        };*/
    }
}
