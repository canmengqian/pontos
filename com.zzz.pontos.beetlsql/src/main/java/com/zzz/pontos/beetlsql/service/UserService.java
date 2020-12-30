package com.zzz.pontos.beetlsql.service;

import com.zzz.pontos.beetlsql.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhengzz
 * Date 2020/12/30
 * @Version 1.0.0
 */
public class UserService {
    @Autowired
   // UserMapper userMapper;
    public void addUser(UserInfo userInfo){
        //userMapper.insert(userInfo);
    }
}
