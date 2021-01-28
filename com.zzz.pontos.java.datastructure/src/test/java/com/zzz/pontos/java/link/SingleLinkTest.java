package com.zzz.pontos.java.link;


import org.junit.Test;

public class SingleLinkTest {
    /**
     * 测试头插法
     */
    @Test
    public void test_headadd() {
        SingleLink<Integer> link = new SingleLink<>();
        System.out.println("--------------------头插法---------------------");
        link.addHead(1);
        link.addHead(2);
        link.addHead(3);
        link.print();
        System.out.println();
        System.out.println("--------------------尾插法---------------------");
        link.addTail(4);
        link.addTail(5);
        link.addTail(6);
        link.print();
        System.out.println();
        System.out.println("--------------------头删法---------------------");
        link.delHead();
        link.print();
        System.out.println();
        link.delHead();
        link.print();
        System.out.println();
        link.delHead();
        link.print();
        System.out.println();
        link.delHead();
        link.print();
        System.out.println();
    }

}
