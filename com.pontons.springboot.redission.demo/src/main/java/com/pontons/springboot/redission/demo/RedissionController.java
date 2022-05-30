package com.pontons.springboot.redission.demo;

import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonRedLock;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className RedissionController
 * @description TODO
 * @date 2022/5/30
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedissionController {

    @Resource
    RedissonClient redissonClient;


    @GetMapping("/lock")
    public void lock(@RequestParam("time") int time) throws InterruptedException {
        RBucket<String> strVal = redissonClient.getBucket("hello");
        strVal.set("hello");
        RLock lock = redissonClient.getLock("lock");
        boolean tryLock = lock.tryLock(2000, 30000, TimeUnit.MILLISECONDS);
        if (tryLock) {
            lock.lock();
            StopWatch stopWatch = new StopWatch();
            stopWatch.start("测试redis锁");
            Thread.sleep(time);
            System.out.println("dothing thing,执行时间" + time + "毫秒");
            stopWatch.stop();
            log.info("当前耗时:{}", stopWatch.prettyPrint());
        }
        lock.unlock();
        log.info("当前线程是否已经释放锁{}", !lock.isLocked());

    }
}
