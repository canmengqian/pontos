package com.pontons.easyrule.demo.bean;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.props.PropertiesInjectorBuilder;
import org.jeasy.props.api.PropertiesInjector;
import org.junit.Test;


@Slf4j
public class PropBeanTest {
    @Test
    public  void testProp() {
        // TODO JDK需要11以上版本
        PropBean propBean = new PropBean();
        PropertiesInjector injector = new PropertiesInjectorBuilder().build();
        injector.injectProperties(propBean);
        log.info(propBean.toString());
    }

}