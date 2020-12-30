package com.zzz.pontos.beetlsql;

import com.zzz.pontos.beetlsql.entity.UserInfo;
import com.zzz.pontos.beetlsql.mapper.SimpleUserInfoMapper;
import org.beetl.sql.core.SQLManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName SimpleTest
 * @Description TODO
 * @Author zhengzz
 * Date 2020/12/30
 * @Version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeetlsqlApplication.class)
@Transactional
public class SimpleTest {
    @Autowired
    SQLManager sqlManager;
    @Autowired
    SimpleUserInfoMapper userInfoMapper;
    @Test
    public void test(){
        sqlManager.single(UserInfo.class,1);
       userInfoMapper.all().forEach(System.out::println);
    }
}
