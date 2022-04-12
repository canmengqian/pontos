package com.pontons.spring.shell.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className TranslationCommands
 * @description TODO
 * @date 2021/12/30
 */

@ShellComponent
@ShellCommandGroup("math")
public class TranslationCommands {
    @ShellMethod(value = "两数相加", prefix = "-", group = "math", key = {"sum", "plus", "add"})
    public int plus(
            @ShellOption(value = "a", defaultValue = "0") int a,
            @ShellOption(value = "b", defaultValue = "0") int b
    ) {
        return a + b;
    }

}
