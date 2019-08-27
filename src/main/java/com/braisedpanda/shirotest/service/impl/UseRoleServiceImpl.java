package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.mapper.UserRoleMapper;
import com.braisedpanda.shirotest.model.po.Role;
import com.braisedpanda.shirotest.model.po.UserRole;
import com.braisedpanda.shirotest.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UseRoleServiceImpl implements UserRoleService{

    @Autowired
    UserRoleMapper userRoleMapper;
    //根据用户名查找权限

    /**
    * @Description: 根据传入的uid查找该用户的所有角色
    * @Param:  uid
    * @return:  List<UserRole>
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<UserRole> getUserRoleByUid(int uid) {
        Example example = new Example(UserRole.class);
        Example.Criteria  criteria = example.createCriteria();
        criteria.andEqualTo("uid",uid);
        List<UserRole> roleList = userRoleMapper.selectByExample(example);
        return roleList;
    }

    
    /** 
    * @Description: 新增userRole 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void insertUserRole(UserRole userRole) {
        userRoleMapper.insert(userRole);
//        permissionMapper.insertUserRole(userRole);
    }


    /**
     * @Description: 在表userRole中删除所有uid的角色
     * @Param:
     * @return:
     * @Date: 2019/8/22 0022
     */
    @Override
    public void deleteRoleByUid(int uid) {
//        permissionMapper.deleteRoleByUid(uid);
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uid",uid);
        userRoleMapper.deleteByExample(example);
    }
}
