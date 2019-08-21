package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.model.po.User;
import com.braisedpanda.shirotest.model.po.UserRole;
import com.braisedpanda.shirotest.mapper.UserMapper;
import com.braisedpanda.shirotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    //查找所有的用户
    @Override
    public List<User> listUsers() {
        List<User> userList = userMapper.listUsers();
        return userList;
    }

    //添加用户


    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    //根据用户名和密码查找用户

    @Override
    public User getUser(String username, String password) {
        User user = userMapper.getUser(username,password);

        return user;
    }
    //删除用户

    @Override
    public void delete(String uid) {
        userMapper.delete(uid);
    }
    //根据uid查找用户

    @Override
    public User getUserByUid(int uid) {
     User user = userMapper.getUserByUid(uid);
     return user;
    }
    //修改用户信息


    @Override
    public void edit(User user) {
        userMapper.edit(user);
    }

    //根据用户名查找权限

    @Override
    public List<UserRole> getRole(int uid) {
        List<UserRole> roleList = userMapper.getRole(uid);
        return roleList;
    }

    @Override
    public List<String> getPermission(String uid) {
        List<String> permissionlist = userMapper.getPermission(uid);
        return permissionlist;
    }


}
