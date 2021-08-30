package com.pontons.easyrule.demo.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className WeatherRule
 * @description TODO
 * @date 2021/8/23
 */
@Rule(name = "weather rule", description = "if it rains then take an umbrella")
public class WeatherRule {
    @Condition
    public boolean itRains(@Fact("rain") boolean rain) {
        return rain;
    }

    @Action(order = 1)
    public void takeAnUmbrella() {
        System.out.println("It rains, take an umbrella!");
    }

    @Action(order = 2)
    public void waiteBus() {
        System.out.println("raining! waite bus");
    }

    @Action(order = 3)
    public void takeBus() {
        System.out.println("take bus and go home");
    }



}
