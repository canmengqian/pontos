package com.zzz.pontos.java.lambada.function.defaultfunct;

public class Service implements GranParentService, ParentService {
    @Override
    public void call() {
        GranParentService.super.call();
        ParentService.super.call();
        System.out.println("call me son !");
    }

    static void name() {
        System.out.println("call me static son !");
    }
}
