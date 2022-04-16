package com.pontons.demo.simpleshiro.ini;

import com.pontons.demo.simpleshiro.Application;
import com.pontons.demo.simpleshiro.entity.SysUserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
class JdbcShiroServiceTest {

    @Resource
    JdbcShiroService jdbcShiroService;

    @Test
    public void invoke() {
        jdbcShiroService.invoke (SysUserInfo.builder ().userId ("zhangsan").password ("123456").build ());
    }

    @Test
    public void invokeFail() {
        jdbcShiroService.invoke (SysUserInfo.builder ().userId ("zhangsan").password ("12345").build ());
    }


}