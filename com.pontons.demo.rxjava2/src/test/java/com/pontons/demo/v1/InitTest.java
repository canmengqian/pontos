package com.pontons.demo.v1;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import org.junit.Test;

import java.util.Locale;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className InitTest
 * @description TODO
 * @date 2022/8/30
 */

public class InitTest {
    @Test
    public void testObservable1() {
        /**
         * amb
         * defer
         * zip
         * just
         * intervel
         * range
         * concat
         * buffersize
         * concatEager
         * fromArray
         * fromCallable
         * fromConsumer
         */
        Observable<String> observable = Observable.just("how", "to", "do", "in", "java");
        Consumer<String> c1 = (r) -> {
            r += "-C1";
            System.out.println(r);
        };
        Consumer<String> c2 = (r) -> {
            r += "-C2";
            System.out.println(r);
        };
        observable.subscribe(c1);
        System.out.println("C2");
        observable.map(c -> c.toUpperCase(Locale.ROOT)).takeLast(2)
                .subscribe(c2);
        desc("PublishSubject");
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        publishSubject.onNext(1);

        // 订阅消费者
        publishSubject.subscribe((t) -> {
            System.out.println(t+"-C3");
        });
        publishSubject.onNext(2);
        publishSubject.onComplete();
        publishSubject.onNext(3);


    }

    public static void desc(String desc) {
        System.out.println("***************************" + desc + "*****************************************");
    }
}
