package com.zzz.pontos.java.lambada.function.defaultfunct;

public interface GranParentService {
    default void call() {
        System.out.println("call me grand parent !");
    }

    static void name() {
        System.out.println("call me static grand parent !");
    }

    void name(String name);

    // int max(int a ,int b);
}
