package com.zzz.pontos.java.function.defaultfunct;

public interface ParentService {
    default  void  call() {
        System.out.println("call me parent !");
    }

    static void name() {
        System.out.println("call me static parent !");
    }
}
