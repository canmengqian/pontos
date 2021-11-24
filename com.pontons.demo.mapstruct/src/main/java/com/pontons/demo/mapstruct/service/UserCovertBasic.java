package com.pontons.demo.mapstruct.service;

import com.pontons.demo.mapstruct.domain.bean.User;
import com.pontons.demo.mapstruct.domain.bean.User1;
import com.pontons.demo.mapstruct.domain.bean.User2;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhengzz
 * @version 1.0.0
 * @description TODO
 * @date 2021/11/10
 */
@Mapper()
public interface UserCovertBasic {
    UserCovertBasic INSTANCE = Mappers.getMapper(UserCovertBasic.class);

    User1 UsertoUser1(User user);

    User User1toUser(User1 user);

    User2 UsertoUser2(User user);
}
