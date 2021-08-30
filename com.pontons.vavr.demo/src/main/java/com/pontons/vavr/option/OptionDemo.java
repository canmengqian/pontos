package com.pontons.vavr.option;

import io.vavr.control.Option;
import org.junit.Test;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className OptionDemo
 * @description TODO
 * @date 2021/8/30
 */
public class OptionDemo {
    @Test
    public void testOption() {
        /*none and some*/
        Option<String> option = Option.none();
        System.out.println("Option.none()获取数据:" + option.getOrElse("Hello"));
        option = Option.some("A");
        System.out.println("Option.none()获取数据:" + option.getOrElse("Hello"));
        /*窄选项*/
        Option<String> option2 = Option.narrow(option);
        System.out.println("窄选项:" + option2.get());
        /*TODO when模式*/
        /*eq比较*/
        System.out.println("Eq:" + option.eq("B"));
        System.out.println("Eq:" + option.eq(option));
        System.out.println("contains:" + option.contains("A"));
        /*TODO collect*/
        /*is*/
        System.out.println("isAsync:" + option.isAsync());
        System.out.println("isDefined:" + option.isDefined());
        /*?*/
        System.out.println("isSingleValued:" + option.isSingleValued());
        System.out.println();
        /*TODO to*/

    }
}
