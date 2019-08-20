package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.bean.po.Permission;
import com.braisedpanda.shirotest.bean.po.Role;
import com.braisedpanda.shirotest.bean.po.RolePermission;
import com.braisedpanda.shirotest.bean.po.UserRole;
import com.braisedpanda.shirotest.mapper.PermissionMapper;
import com.braisedpanda.shirotest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    //添加角色信息
    @Override
    public void insertRole(Role role) {
        permissionMapper.insertRole(role);
    }

    //查询所有的权限信息

    @Override
    public List<Permission> getAllPermission() {
        List<Permission> permissionList = permissionMapper.getAllPermission();
        return permissionList;
    }
    //根据权限id查出对应的权限

    @Override
    public Permission getPermissionById(String s1) {
       Permission permission =  permissionMapper.getPermissionById(s1);
       return permission;
    }
    //添加对应的角色-权限表

    @Override
    public void insertRolePermission(RolePermission rp) {
        permissionMapper.insertRolePermission(rp);
    }
    //查找所有的角色

    @Override
    public List<Role> getAllRole() {
        List<Role> roleList = permissionMapper.getAllRole();
        return  roleList;
    }
    //根据uid查找出所有的角色

    @Override
    public List<UserRole> getRoleById(String uid) {
        List<UserRole> userRoleList =permissionMapper.getRoleById(uid);
       return userRoleList;
    }

    //根据roleId在role中查询相应的role

    @Override
    public Role getRoleByroleId(String roleId) {
        Role role = permissionMapper.getRoleByroleId(roleId);
        return role;
    }

    //新增userRole

    @Override
    public void insertUserRole(UserRole userRole) {
        permissionMapper.insertUserRole(userRole);
    }
    //在表userRole中删除所有uid的角色

    @Override
    public void deleteRoleByUid(int uid) {
        permissionMapper.deleteRoleByUid(uid);
    }

    //查找所有的rolePermission内容
    @Override
    public List<RolePermission> listRolePermission() {
        List<RolePermission> rolePermissionList = permissionMapper.listRolePermission();
        return rolePermissionList;
    }
    //根据rPId删除角色所拥有的权限

    @Override
    public void deleteRolePermissionById(String rPId) {
        permissionMapper.deleteRolePermissionById(rPId);
    }

    //根据rPId查找rolePermission对象

    @Override
    public List<RolePermission>  getRolePermissionById(String rPId) {
        List<RolePermission> rolePermissionlist  = permissionMapper.getRolePermissionById(rPId);
        return rolePermissionlist;
    }
    //根据roleId删除rolePermission表中所有的权限
    @Override
    public void deleteRolePermissionByroleId(String roleId) {
        permissionMapper.deleteRolePermissionByroleId(roleId);
    }

    //在role表中更新role的相关权限、名称等信息

    @Override
    public void updateRole(Role role) {
        permissionMapper.updateRole(role);
    }

    //根据roleId删除role表中的role

    @Override
    public void deleteRoleByroleId(String roleId) {
        permissionMapper.deleteRoleByroleId(roleId);
    }
}
