package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.RolePermission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolePermissionService {

    //添加对应的角色-权限表

    void insertRolePermission(RolePermission rp);

    //查找所有的rolePermission内容

    List<RolePermission> selectAllRolePermission();
    //根据rPId删除角色所拥有的权限

    void deleteRolePermissionById(RolePermission rolePermission);

    //根据roleId查找rolePermission对象
    List<RolePermission>  selectRolePermissionByRoleId(String roleId);

    //根据roleId删除rolePermission表中所有的权限
    void deleteRolePermissionByroleId(String roleId);

    //通过uid获取permission字段
    List<String> getPermission(String uid);

}
