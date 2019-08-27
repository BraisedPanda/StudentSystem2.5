package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.model.po.Permission;
import com.braisedpanda.shirotest.model.po.Role;
import com.braisedpanda.shirotest.model.po.RolePermission;
import com.braisedpanda.shirotest.model.po.UserRole;
import com.braisedpanda.shirotest.mapper.PermissionMapper;
import com.braisedpanda.shirotest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;



    
    /** 
    * @Description: 查询所有的权限信息
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public List<Permission> selecAllPermission() {
//        List<Permission> permissionList = permissionMapper.getAllPermission();
        List<Permission> permissionList = permissionMapper.selectAll();
        return permissionList;
    }

    /**
    * @Description: 根据权限id查出对应的权限
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public Permission getPermissionById(String per) {
//       Permission permission =  permissionMapper.getPermissionById(s1);
        Permission permission =  permissionMapper.selectByPrimaryKey(per);
       return permission;

    }




}
