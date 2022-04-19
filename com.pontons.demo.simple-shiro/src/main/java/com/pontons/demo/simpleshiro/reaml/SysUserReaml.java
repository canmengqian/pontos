package com.pontons.demo.simpleshiro.reaml;

import com.pontons.demo.simpleshiro.entity.SysPermission;
import com.pontons.demo.simpleshiro.entity.SysRole;
import com.pontons.demo.simpleshiro.entity.SysUserInfo;
import com.pontons.demo.simpleshiro.mapper.SysUserInfoMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SysUserReaml extends AuthorizingRealm {


    @Resource
    SysUserInfoMapper userInfoMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //能进入到这里，表示账号已经通过验证了
        String userId = (String) principals.getPrimaryPrincipal ();
        //通过DAO获取角色和权限
        Set<String> permissions = userInfoMapper.getAllPerssion (userId).stream ().map (SysPermission::getPerName).collect(Collectors.toSet());
        Set<String> roles = userInfoMapper.getAllRole (userId).stream ().map (SysRole::getRoleName).collect(Collectors.toSet());
        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo ();
        //把通过DAO获取到的角色和权限放进去
        s.setRoles (roles);
        s.setStringPermissions (permissions);
        return s;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String userId= token.getPrincipal().toString();
        String password= new String( t.getPassword());
        //获取数据库中的密码
        SysUserInfo user = userInfoMapper.createLambdaQuery ().andEq (SysUserInfo::getUserId,userId).andEq (SysUserInfo::getPassword,password).single ();


        //如果为空就是账号不存在，如果不相同就是密码错误，但是都抛出AuthenticationException，而不是抛出具体错误原因，免得给破解者提供帮助信息
        if(null==user)
            throw new AuthenticationException();

        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        return new SimpleAuthenticationInfo(userId,password,user.getUserName ());
    }
}
