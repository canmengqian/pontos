package com.zzz.pontos.java.function.defaultfunct;

public interface GranParentService {
    default  void call () {
        System.out.println("call me grand parent !");
    }
}
