package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.mapper.RoleMapper;
import com.braisedpanda.shirotest.model.po.Role;
import com.braisedpanda.shirotest.model.po.UserRole;
import com.braisedpanda.shirotest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;


    /**
    * @Description: 添加角色信息
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void insertRole(Role role) {
          roleMapper.insert(role);
//        roleMapper.insertRole(role);
    }

    /**
    * @Description:  查找所有的角色
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<Role> selectAllRole() {
//        List<Role> roleList = permissionMapper.getAllRole();
        List<Role> roleList = roleMapper.selectAll();
        return  roleList;
    }
    

    
    /** 
    * @Description: 根据roleId在role中查询相应的role 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public Role selectRoleById(Role rol) {
//        Role role = permissionMapper.getRoleByroleId(roleId);
        Role role = roleMapper.selectByPrimaryKey(rol);
        return role;
    }



    /**
    * @Description: 在role表中更新role的相关权限、名称等信息
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void updateRole(Role role) {
//        permissionMapper.updateRole(role);
        roleMapper.updateByPrimaryKey(role);
    }

    /**
    * @Description:  根据roleId删除role表中的role
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void deleteRoleByroleId(Role role) {
//        permissionMapper.deleteRoleByroleId(roleId);
        roleMapper.deleteByPrimaryKey(role);
    }
}
