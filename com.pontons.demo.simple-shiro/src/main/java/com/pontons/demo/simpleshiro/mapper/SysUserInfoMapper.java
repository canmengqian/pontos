package com.pontons.demo.simpleshiro.mapper;
import org.beetl.sql.mapper.BaseMapper;
import com.pontons.demo.simpleshiro.entity.*;
import org.beetl.sql.mapper.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 
* gen by beetlsql3 mapper 2022-04-16
*/
@Repository
public interface SysUserInfoMapper extends BaseMapper<SysUserInfo> {

    List<SysRole> getAllRole(@Param ("userId") String userId);


    List<SysPermission> getAllPerssion(@Param ("userId") String userId);
}
