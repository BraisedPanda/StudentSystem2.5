package com.braisedpanda.shirotest.mapper;


import com.braisedpanda.shirotest.bean.po.User;
import com.braisedpanda.shirotest.bean.po.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    //查找所有的用户
    List<User> listUsers();
    //添加用户
    void addUser(User user);
    //根据用户名、密码查找用户
    User getUser(@Param("username") String username, @Param("password") String password);

    void delete(String uid);

    User getUserByUid(int uid);

    void edit(User user);


    List<UserRole> getRole(int uid);

    List<String> getPermission(String uid);
}
