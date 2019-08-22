package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.model.po.User;
import com.braisedpanda.shirotest.model.po.UserRole;
import com.braisedpanda.shirotest.mapper.UserMapper;
import com.braisedpanda.shirotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
    * @Description: 查找所有的用户
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<User> selectAllUser() {
//        List<User> userList = userMapper.listUsers();
        List<User> userList = userMapper.selectAll();
        return userList;

    }

    /**
    * @Description: 新增用户
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
//        userMapper.addUser(user);
    }


    /**
    * @Description: 根据用户名和密码查找用户
    * @Param:  username:用户名  password:密码
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public User selectUserByUsernameAndPasword(String username, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",password);
//        User user = userMapper.getUser(username,password);
        User user =userMapper.selectOneByExample(example);
            return user;
    }
    
    /** 
    * @Description: 删除用户 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void deleteUser(User user) {
        userMapper.delete(user);
//        userMapper.delete(uid);
    }

    /** 
    * @Description: 根据Uid查找用户
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public User selectUserById(User user) {
        User user1 = userMapper.selectByPrimaryKey(user);
//     User user = userMapper.getUserByUid(uid);
     return user1;
    }

   /** 
   * @Description: 更新用户信息
   * @Param:  
   * @return: 
   * @Date: 2019/8/22 0022 
   */ 
    @Override
    public void updateUserById(User user) {
        userMapper.updateByPrimaryKey(user);
//    userMapper.edit(user);
    }



}
