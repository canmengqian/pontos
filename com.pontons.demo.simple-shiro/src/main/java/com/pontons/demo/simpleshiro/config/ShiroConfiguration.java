package com.pontons.demo.simpleshiro.config;

import com.pontons.demo.simpleshiro.reaml.SysUserReaml;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class ShiroConfiguration {

    @Resource
    SysUserReaml sysUserReaml;

    @Bean
    public DefaultSecurityManager setSecurityManager() {
        //加载配置文件，并获取工厂
        DefaultSecurityManager sm = new DefaultSecurityManager ();
        sm.setRealm (sysUserReaml);
        //将安全管理者放入全局对象
        SecurityUtils.setSecurityManager (sm);
        return sm;
    }
}
