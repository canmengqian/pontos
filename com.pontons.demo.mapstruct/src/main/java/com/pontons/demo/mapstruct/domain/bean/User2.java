package com.pontons.demo.mapstruct.domain.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className User2
 * @description TODO
 * @date 2021/11/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2 {
    private Integer id;
    private String name;
    private String createTime;
}
