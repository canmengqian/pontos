package com.pontons.vavr.Try;

import io.vavr.CheckedFunction0;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className TryDemo
 * @description TODO
 * @date 2021/8/30
 */
public class TryDemo {
    @Test
    public void testTry() {
        /*normal*/
        Try<List> tryDemo = Try.of(() -> List.of(1, 2, 3, 4));
        List l = tryDemo.onFailure(e -> System.err.println("异常"))
                .andThenTry(e -> System.out.println("step1:"+e))
                .andThenTry(e -> System.err.println("step2"+e))
                .andFinally((() -> System.err.println("finaly")))
                .get();
        l.stdout();

    }
}
