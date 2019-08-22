package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.mapper.UserRoleMapper;
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
    public List<UserRole> selectUserRoleByUid(int uid) {
        Example example = new Example(UserRole.class);
        Example.Criteria  criteria = example.createCriteria();
        criteria.andEqualTo("uid",uid);
        List<UserRole> roleList = userRoleMapper.selectByExample(example);
        return roleList;
    }

}
