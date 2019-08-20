package com.braisedpanda.shirotest.service;


import com.braisedpanda.shirotest.bean.po.User;
import com.braisedpanda.shirotest.bean.po.UserRole;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    //查找所有的用户


    List<User> listUsers();

    //添加用户

    @CacheEvict(value="users",key="'addUser:'+#user.uid",allEntries = true)
    void addUser(User user);

    //根据用户名和密码查找用户


    User getUser(String username, String password);
    @CacheEvict(value="users",allEntries = true,key="'delete:'+#uid")
    void delete(String uid);
    @Cacheable(value="users" , key="'getUserByUid:'+#uid")
    User getUserByUid(int uid);

    @CacheEvict(value="users",allEntries = true,key="'edit:'+#user.uid")
    void edit(User user);


    @Cacheable(value="users" , key="'getRole:'+#uid")
    List<UserRole> getRole(int uid);

    @Cacheable(value="users" , key="'getPermission:'+#uid")
    List<String> getPermission(String uid);
}
