package com.pontons.easyrule.demo;

import com.pontons.easyrule.demo.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.junit.Test;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className EasyRandomTest
 * @description TODO
 * @date 2021/8/23
 */
@Slf4j
public class EasyRandomTest {
    @Test
    public void testRandomPerson() {
        EasyRandom generator = new EasyRandom();
        Person person = generator.nextObject(Person.class);
        log.info(person.toString());

    }
}
