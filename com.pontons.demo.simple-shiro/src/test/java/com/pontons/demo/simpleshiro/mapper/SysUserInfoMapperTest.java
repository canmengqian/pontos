package com.pontons.demo.simpleshiro.mapper;

import com.pontons.demo.simpleshiro.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class SysUserInfoMapperTest {
    @Resource
    SysUserInfoMapper userInfoMapper;

    @Test
    public void  test(){
        userInfoMapper.createLambdaQuery ().select ();
    }

}