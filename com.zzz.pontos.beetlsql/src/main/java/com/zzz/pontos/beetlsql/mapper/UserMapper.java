package com.zzz.pontos.beetlsql.mapper;

import com.zzz.pontos.beetlsql.entity.UserInfo;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

/**
 * @ClassName SimpleUserInfoMapper
 * @Description TODO
 * @Author zhengzz
 * Date 2020/12/30
 * @Version 1.0.0
 */
@SqlResource("user")
public interface UserMapper extends BaseMapper<UserInfo> {
    public  void selectOne();
}