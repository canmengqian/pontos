package com.pontons.drools.entity;


import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.FactHandle;

@Slf4j
public class PersonTest {

    KieSession kieSession;
    KieContainer kieContainer;


    @Before
    public  void init() {
        // 设置服务
        KieServices kss = KieServices.Factory.get();
        // 设置容器
         kieContainer = kss.getKieClasspathContainer();
    }
    /**
     * 测试规则1
     */
    @Test
    public  void test1() {

    }
    /**
     * 测试规则2
     */
    @Test
    public  void test2() {
        kieSession = kieContainer.newKieSession("test001");
        AgendaFilter filter = new RuleNameStartsWithAgendaFilter("test002");
        kieSession.fireAllRules();
        Person person = Person.builder().name("zhangsan").age(30).build();
        FactHandle  handle =kieSession.insert(person);
        System.out.println("execute:"+kieSession.fireAllRules());
        kieSession.fireAllRules();
        log.info("person result :"+person.toString());
        kieSession.dispose();
    }

}