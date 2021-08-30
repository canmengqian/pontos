package com.zzz.pontos.beetlsql.entity;

import lombok.Data;
import lombok.ToString;
import org.beetl.sql.annotation.entity.AssignID;
import org.beetl.sql.annotation.entity.Table;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author zhengzz
 * Date 2020/12/30
 * @Version 1.0.0
 */
@Table(name = "sys_user")
@Data
@ToString
public class UserInfo {

    @AssignID
    private Long id; //主键ID
    private String name;
    private Integer departmentId;
}