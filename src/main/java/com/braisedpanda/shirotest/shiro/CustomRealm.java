package com.braisedpanda.shirotest.shiro;



import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.bean.UserRole;
import com.braisedpanda.shirotest.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

//        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = (User)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查询登录用户所拥有的角色，并添加角色
        int uid = user.getUid();
        List<UserRole> roleList = userService.getRole(uid);

        for (UserRole role:
             roleList) {
           info.addRole(role.getRole());


           String roleId= role.getroleId();
            List<String> permissionList= userService.getPermission(roleId);
            //查询登录用户所拥有的权限，并添加权限
            for (String  permission:
                    permissionList) {
                info.addStringPermission(permission);
            }

        }

        return info;
    }

    //重写验证身份的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();

        String password = new String((char[]) authenticationToken.getCredentials());


        User user = userService.getUser(username,password);

        if (user == null) {
            throw new AccountException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(user, password, getName());

    }



}