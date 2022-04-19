package com.pontons.demo.simpleshiro.mapper;

import com.pontons.demo.simpleshiro.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class SysUserInfoMapperTest {

    @Resource
    SysUserInfoMapper sysUserInfoMapper;
    @Test
    public void test(){
        sysUserInfoMapper.createLambdaQuery ().select ();
    }

    @Test
    public  void testgetAllRole(){
        sysUserInfoMapper.getAllRole ("zhansgan").forEach (r->{
            System.out.println (r.toString ());
        });
    }

    @Test
    public void testgetAllPerssion(){
        sysUserInfoMapper.getAllPerssion ("zhangsan").forEach (p->{
            System.out.println (p.toString ());
        });
    }
}