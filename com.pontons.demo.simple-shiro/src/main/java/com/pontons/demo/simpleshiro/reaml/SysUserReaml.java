package com.pontons.demo.simpleshiro.reaml;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SysUserReaml extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //能进入到这里，表示账号已经通过验证了
        String userId = (String) principals.getPrimaryPrincipal ();
        //通过DAO获取角色和权限
        Set<String> permissions = null;
        Set<String> roles = null;

        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo ();
        //把通过DAO获取到的角色和权限放进去
        s.setStringPermissions (permissions);
        s.setRoles (roles);
        return s;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
