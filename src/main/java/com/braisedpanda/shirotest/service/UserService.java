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
    List<User> selectAllUser();

    //添加用户
    void insertUser(User user);

    //根据用户名和密码查找用户
    User selectUserByUsernameAndPasword(String username, String password);

    //删除用户
    void deleteUser(User user);

    //根据uid查找用户
    User selectUserById(User user);

    //更新用户信息
    void updateUserById(User user);

}
