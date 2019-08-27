package com.braisedpanda.shirotest.service.impl;


import com.braisedpanda.shirotest.mapper.RolePermissionMapper;
import com.braisedpanda.shirotest.model.po.RolePermission;
import com.braisedpanda.shirotest.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    /** 
    * @Description: 添加对应的角色-权限表
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void insertRolePermission(RolePermission rp) {
        rolePermissionMapper.insert(rp);
    }

    /**
    * @Description: 查找所有的rolePermission内容
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<RolePermission> listRolePermission() {

        List<RolePermission> rolePermissionList = rolePermissionMapper.selectAll();
        return rolePermissionList;
    }

    /**
    * @Description: 根据rPId删除角色所拥有的权限
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void deleteRolePermissionById(RolePermission rolePermission) {
//        permissionMapper.deleteRolePermissionById(rPId);
        rolePermissionMapper.deleteByPrimaryKey(rolePermission);
    }


    /**
    * @Description: 根据roleId查找rolePermission对象
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<RolePermission>  listRolePermissionByRoleId(String roleId) {
//        List<RolePermission> rolePermissionlist  = permissionMapper.getRolePermissionById(rPId);
        Example example = new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",roleId);
        List<RolePermission> rolePermissionlist = rolePermissionMapper.selectByExample(example);
        return rolePermissionlist;
    }

    /**
    * @Description: 根据roleId删除rolePermission表中所有的权限
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void deleteRolePermissionByroleId(String roleId) {
//        permissionMapper.deleteRolePermissionByroleId(roleId);
        Example example = new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",roleId);
        rolePermissionMapper.deleteByExample(example);

    }


    /**
     * @Description: 通过uid获取该用户所有的权限
     * @Param:
     * @return:
     * @Date: 2019/8/22 0022
     */
    @Override
    public List<String> getPermission(String uid) {
        List<String> permissionlist = rolePermissionMapper.getPermission(uid);
        return permissionlist;
    }

    /**
    * @Description: 统计出RolePermission表中所有的记录数
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */
    @Override
    public int countRolePermission() {
        RolePermission rp = new RolePermission();
        int count = rolePermissionMapper.selectCount(rp);
        return count;
    }
}
