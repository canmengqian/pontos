package com.pontons.jdk.demo.lang.reflect;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className ArrayTest
 * @description TODO
 * @date 2021/11/12
 */
public class ArrayTest {

    @Test
    public void newInst() {
        String[] stringArray = (String[]) Array.newInstance(String.class, 3);
        Array.set(stringArray, 0, "Mahesh");
        Array.set(stringArray, 1, "Ramesh");
        Array.set(stringArray, 2, "Suresh");
        System.out.println("数组长度" + Array.getLength(stringArray));
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(Array.get(stringArray, i));
        }
        Array.getLong(stringArray,0);

    }
}
