package com.pontons.drools.entity;

import lombok.*;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Person
 * @description TODO
 * @date 2021/8/16
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    String name;
    int age;
}
