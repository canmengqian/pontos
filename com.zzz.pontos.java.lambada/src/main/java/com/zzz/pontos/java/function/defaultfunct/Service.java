package com.zzz.pontos.java.function.defaultfunct;

public class Service implements  GranParentService,ParentService {
    @Override
    public void call() {
        GranParentService.super.call();
        ParentService.super.call();
        System.out.println("call me son !");
    }
}
