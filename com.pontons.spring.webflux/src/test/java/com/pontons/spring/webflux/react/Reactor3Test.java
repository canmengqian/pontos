package com.pontons.spring.webflux.react;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Reactor3Test
 * @description TODO
 * @date 2022/2/8
 */
@Slf4j
public class Reactor3Test {
    @Test
    public void testPreMono() {

    }

    @Test
    public void testPreFlux() {
       /* Flux<String> flux = Flux.just();
        Flux.from();
        Flux.defer();
        Flux.create();
        Flux.merge();
        Flux.mergeSequentialDelayError();
        Flux.mergeComparing();
        Flux.mergeSequential();
        Flux.combineLatest();
        Flux.fromArray();
        Flux.fromIterable();
        Flux.fromStream();
        Flux.firstWithSignal();
        Flux.firstWithValue();
        Flux.generate();
        Flux.interval();
        Flux.never();
        Flux.push();
        Flux.zip();
        Flux.range();
        Flux.using();
        Flux.usingWhen();
        Flux.error();
        flux.contextWrite();
        flux.doAfterTerminate();
        flux.doFinally();
        flux.doFirst();
        flux.doOnCancel();
        flux.doOnComplete();
        flux.doOnDiscard();
        flux.doOnEach();
        flux.doOnError();
        flux.doOnNext();
        flux.doOnRequest();
        flux.doOnNext();
        flux.doOnSubscribe();
        flux.window();
        flux.windowTimeout();
        flux.windowUntil();
        flux.windowUntilChanged();
        flux.flatMap();
        flux.flatMapIterable();
        flux.flatMapDelayError();
        flux.flatMapSequential();
        flux.flatMapSequentialDelayError();
        flux.elapsed();
        flux.defaultIfEmpty("");
        flux.expandDeep();
        flux.expand();
        flux.delayElements();
        flux.delaySequence();
        flux.delaySubscription();
        flux.delayUntil()
        // flux.all()
        // flux.any()
        // flux.as()
        // flux.cast();
        // flux.blockFirst(); flux.blockLast();
        //flux.buffer();
        // flux.bufferTimeout();
        flux.bufferUntil(null);
        flux.bufferWhen(null, null, null);
        flux.bufferWhile(null);
        flux.bufferUntilChanged();

        flux.cache();
        flux.checkpoint();
        flux.collect();
        flux.collectList();
        flux.collectSortedList();
        flux.collectMap();
        flux.collectMap();
        flux.concatMap();
        flux.concatMapDelayError();
        flux.concatMapIterable();
        flux.concatWith();
        flux.concatWithValues();
        flux.count();
        flux.distinct();
        flux.distinctUntilChanged();
        flux.or();
        flux.filter();
        flux.filterWhen();
        flux.zipWith();
        flux.zipWithIterable();
        flux.getPrefetch();
        flux.groupBy();
        flux.handle();
        flux.hasElement();
        flux.hide();
        flux.groupBy();
        flux.groupJoin();
        flux.transform();
        flux.transformDeferred();
        flux.transformDeferredContextual();
        flux.skip();
        flux.skipLast();
        flux.skipUntil();
        flux.skipUntilOther();
        flux.take();
        flux.takeLast();
        flux.takeUntil();
        flux.takeUntilOther();
        flux.index();
        flux.join();
        flux.last();
        flux.log();
        flux.then();
        flux.thenEmpty();
        flux.switchIfEmpty();
        flux.switchMap();
        flux.switchOnFirst();
        flux.toIterable();
        flux.toStream();
        flux.sample();
        flux.sampleFirst();
        flux.sampleTimeout();
        flux.startWith();
        flux.timestamp();
        flux.map();
        flux.reduce();
        flux.retry();
        flux.repeat();
        flux.replay();
        flux.subscribe();
        flux.subscribeOn();
        flux.subscribeWith();*/

    }

    @Test
    public void testFluxGenner() throws InterruptedException {
        System.out.println("-----数据生成------");
        // just()
        Flux<Integer> f1 = Flux.just(1, 2, 3, 4, 5);
        f1.subscribe(System.out::print);
        System.out.println();
        // fromArray
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        Flux<Integer> f2 = Flux.fromArray(array);
        // from
        Flux.from(f1);
        // empty
        Flux f3 = Flux.empty();
        // range
        Flux.range(0, 10).subscribe(System.out::print);
        Flux<Long> longFlux = Flux.interval(Duration.ofSeconds(1));
        //take方法准确获取订阅数据量
        Disposable disposable = longFlux.take(50).subscribe(x -> log.info("->{}", x));
        //不能停止正在推送数据中的Flux或Mono流
        Thread.sleep(10000);
        //彻底停止正在推送数据中的Flux或Mono流

        //  disposable.dispose();
        log.info("->Stop");

        System.out.println();
       /* System.out.println("-----empty------");
        Flux.empty().switchIfEmpty(Flux.just("1", "2", "3", "4", "5")).filter(n -> Integer.parseInt((String) n) > 3)
                .map(N -> {
                    int num = Integer.parseInt((String) N);
                    if (num == 5) {
                        throw new IllegalArgumentException("非法参数");
                    }
                    return String.valueOf(num);
                })
                .doOnError(Myconsumer::concatStrError)
                .subscribe(Myconsumer::concatStr);*/

    }


    public static class Myconsumer {
        public static String concatStr(Object str) {
            String s = (String) str;
            s += "|";
            System.out.println("concat str: " + s);
            return s;
        }

        public static void concatStrError(Throwable th) {
            System.out.println("捕获异常:" + th.getMessage());
        }
    }

    @Test
    public void testBuffer() {
        /**
         * buffer 类似 数组切割
         */
        // 每缓存5个元素输出一个数组
        Flux.range(1, 10).buffer(5).subscribe(System.out::println);
        // 每缓存8个元素输出一个数组
        Flux.range(1, 10).buffer(8).subscribe(System.out::println);
        // 每2分为1数组
        Flux.range(1, 10).bufferUntil(n -> n % 2 == 0).subscribe(System.out::print);
        System.out.println();
        // 能被2整除的归为同一个数组
        Flux.range(1, 10).bufferWhile(n -> n % 2 == 0).subscribe(System.out::print);
        System.out.println();
        //Flux.range(1, 10).bufferWhen()
        // 小于5的元素归为一个数组
        Flux.range(1, 10).bufferUntilChanged(n -> n <= 5).subscribe(System.out::println);
        System.out.println("-----Time Out -----");
        Flux<Integer> f5 = Flux.range(1, 100000000);
        Flux.from(f5.filter(n -> n.intValue() > 99999999)).bufferTimeout(2, Duration.ofNanos(1)).subscribe(System.out::print);
    }

    @Test
    public void testFilter() {
        Flux.range(1, 10);

    }

    @Test
    public void testWindow() {
        Flux.range(1, 100).window(20).subscribe(System.out::println);
    }


    public void change(Integer i){
        if(i>=10){
            return ;
        }
        i = i+1;
        change(i);
        System.out.println(i.hashCode());
    }
    @Test
    public void testI(){
        Integer i =1;
        System.out.println(i.hashCode());
        change(i);
        System.out.println(i);
    }

}
