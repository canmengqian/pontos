package com.pontons.drools;

import com.pontons.drools.entity.Order;
import com.pontons.drools.entity.User;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DroolsTest
 * @Description TODO
 * @Author zhengzz
 * Date 2021/4/9
 * @Version 1.0.0
 */
public class DroolsTest {

    @Test
    public void test() throws Exception {
        KieServices kis = KieServices.Factory.get();
        // From the kie services, a container is created from the classpath
        KieContainer kc = kis.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("HelloWorldKS");
        System.out.println(ks.fireAllRules());
        execute(kc);
    }

    public static void execute(KieContainer kc) throws Exception {
        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kc.newKieSession("point-rulesKS");

        List<Order> orderList = getInitData();

        for (int i = 0; i < orderList.size(); i++) {
            Order o = orderList.get(i);
            ksession.insert(o);
            ksession.fireAllRules();
            // 执行完规则后, 执行相关的逻辑
            addScore(o);
        }

        ksession.dispose();

    }


    private static void addScore(Order o) {
        System.out.println("用户" + o.getUser().getName() + "享受额外增加积分: " + o.getScore());
    }

    private static List<Order> getInitData() throws Exception {
        List<Order> orderList = new ArrayList<Order>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        {
            Order order = new Order();
            order.setAmout(80);
            order.setBookingDate(df.parse("2015-07-01"));
            User user = new User();
            user.setLevel(1);
            user.setName("Name1");
            order.setUser(user);
            order.setScore(111);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmout(200);
            order.setBookingDate(df.parse("2015-07-02"));
            User user = new User();
            user.setLevel(2);
            user.setName("Name2");
            order.setUser(user);
            orderList.add(order);
        }
        return orderList;
    }

}
