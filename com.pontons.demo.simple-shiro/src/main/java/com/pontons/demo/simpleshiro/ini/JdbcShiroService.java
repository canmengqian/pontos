package com.pontons.demo.simpleshiro.ini;

import com.pontons.demo.simpleshiro.entity.SysUserInfo;
import com.pontons.demo.simpleshiro.reaml.SysUserReaml;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class JdbcShiroService {
    @Resource
    SysUserReaml sysUserReaml;

    public void invoke(SysUserInfo user) {
        //登陆每个用户
        login (user);
        List<String> roles = CollectionUtils.asList ("admin");
        System.out.println ("-------how2j 分割线------");
        //判断能够登录的用户是否拥有某个角色
        for (String role : roles) {
            if (hasRole (role)) {
                System.out.printf ("%s\t 拥有角色: %s\t%n", user.getUserName (), role);
                continue;
            }
            throw new AuthenticationException ("error role");
        }
        System.out.println ("-------how2j 分割线------");
        //判断能够登录的用户，是否拥有某种权限
       /* for (SysUserInfo user : users) {
            for (String permit : permits) {
                if (login (user)) {
                    if (isPermitted (user, permit))
                        System.out.printf ("%s\t 拥有权限: %s\t%n", user.getName (), permit);
                    else
                        System.out.printf ("%s\t 不拥有权限: %s\t%n", user.getName (), permit);
                }
            }
        }*/
    }


    private boolean hasRole(String role) {
        Subject subject = getSubject ();
        return subject.hasRole (role);
    }

    private boolean isPermitted(String permit) {
        Subject subject = getSubject ();
        return subject.isPermitted (permit);
    }

    private Subject getSubject() {
        //全局对象通过安全管理者生成Subject对象
        Subject subject = SecurityUtils.getSubject ();
        return subject;
    }


    private void login(SysUserInfo user) {
        Subject subject = getSubject ();
        subject.logout ();
        //封装用户的数据
        UsernamePasswordToken token = new UsernamePasswordToken (user.getUserId (), user.getPassword ());
        //将用户的数据token 最终传递到Realm中进行对比
        subject.login (token);
        if(!subject.isAuthenticated ()){
            throw  new AuthenticationException ("login fail");
        }
    }
}
