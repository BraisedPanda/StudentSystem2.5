package com.braisedpanda.shirotest.service;


import com.braisedpanda.shirotest.model.po.User;
import com.braisedpanda.shirotest.model.po.UserRole;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    //查找所有的用户


    List<User> listUsers();

    //添加用户


    void addUser(User user);

    //根据用户名和密码查找用户


    User getUser(String username, String password);

    void delete(String uid);

    User getUserByUid(int uid);


    void edit(User user);



    List<UserRole> getRole(int uid);


    List<String> getPermission(String uid);






}
