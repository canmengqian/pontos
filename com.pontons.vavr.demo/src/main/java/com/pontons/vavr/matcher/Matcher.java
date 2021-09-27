package com.pontons.vavr.matcher;

import io.vavr.Predicates;
import org.junit.Test;

import java.util.Random;

import static io.vavr.API.*;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Matcher
 * @description 模式匹配
 * @date 2021/8/30
 */
public class Matcher {
    @Test
    public void testMatcher() {
        int num = new Random().nextInt(10);
        System.out.println(num);
        /*Predicates 类型推断*/
        String s = Match(num).of(
                Case($(Predicates.is(1)), "one"),
                Case($(Predicates.isIn(2, 3, 4, 5, 6)), "two"),
                Case($(), "?")
        );
        System.out.println(s);
    }
}
