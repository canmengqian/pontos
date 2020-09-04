package com.zzz.pontos.java.lambada.function.defaultfunct;

public interface GranParentService {
    default  void call () {
        System.out.println("call me grand parent !");
    }
}
