package com.pontons.easyrule.demo.bean;

import lombok.Data;
import lombok.ToString;
import org.jeasy.props.annotations.Property;
import org.jeasy.props.annotations.SystemProperty;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className PropBean
 * @description TODO
 * @date 2021/8/23
 */
@ToString
@Data
public class PropBean {
    @Property(source = "test.properties" ,key = "name" ,defaultValue = "zhangsan")
    String name ;

    @SystemProperty(value = "os.name",defaultValue = "windows")
    String osName;
}
