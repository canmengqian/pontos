package com.zzz.pontos.java.lambada.function.interfaces;

import org.junit.jupiter.api.Test;

public class FunctionInterfaceTest {
    @Test
    public void  testFunctionInterface() {
        Service service  = (str) -> {
            return str;
        };

        String msg = service.showmasseage("hello");
        System.out.println(msg);

        service.doSomething("cat");
    }
}
