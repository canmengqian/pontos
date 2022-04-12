package com.pontnos.spring.batch.bean;

import lombok.*;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Person
 * @description TODO
 * @date 2021/12/9
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person {
    private String lastName;
    private String firstName;
}
