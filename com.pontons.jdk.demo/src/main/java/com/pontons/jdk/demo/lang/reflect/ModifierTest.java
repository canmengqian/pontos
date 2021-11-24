package com.pontons.jdk.demo.lang.reflect;

import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className ModifierTest
 * @description TODO
 * @date 2021/11/12
 */
public class ModifierTest {
    @Test
    public void test() {
        boolean sync = Modifier.isSynchronized(1);
        System.out.println(sync);
    }
}
