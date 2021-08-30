package com.pontons.easyrule.demo;


import org.jeasy.states.api.State;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * @author zhengzz
 * @version 1.0.0
 * @className EasyStatTest
 * @description TODO
 * @date 2021/8/23
 */
public class EasyStatTest {
    @Test
    public  void testState(){
        State locked = new State("locked");
        State unlocked = new State("unlocked");
        Set<State> states = new HashSet<>();
        states.add(locked);
        states.add(unlocked);


    }
}
