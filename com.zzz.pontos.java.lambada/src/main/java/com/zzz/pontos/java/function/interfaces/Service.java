package com.zzz.pontos.java.function.interfaces;
@FunctionalInterface
interface Service {
    String showmasseage(String message) ;
    default  void doSomething(String thing) {
        System.out.println(" do some thing now !");
    }

    //void sayHello(String str) ;
}
