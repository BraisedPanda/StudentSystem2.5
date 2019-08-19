package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Permission;
import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.RolePermission;
import com.braisedpanda.shirotest.bean.UserRole;
import com.braisedpanda.shirotest.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    PermissionMapper permissionMapper;

    //添加角色信息
    @Override
    public void addRole(Role role) {
        permissionMapper.addRole(role);
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
    public void addRole_Permission(RolePermission rp) {
        permissionMapper.addRole_Permission(rp);
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
        List<UserRole> user_roleList =permissionMapper.getRoleById(uid);
       return user_roleList;
    }

    //根据roleId在role中查询相应的role

    @Override
    public Role getRoleByroleId(String roleId) {
        Role role = permissionMapper.getRoleByroleId(roleId);
        return role;
    }

    //新增user_role

    @Override
    public void addUser_Role(UserRole user_role) {
        permissionMapper.addUser_Role(user_role);
    }
    //在表User_Role中删除所有uid的角色

    @Override
    public void deleteRoleByUid(int uid) {
        permissionMapper.deleteRoleByUid(uid);
    }

    //查找所有的role_permission内容
    @Override
    public List<RolePermission> getAllRole_Permission() {
        List<RolePermission> role_permissionList = permissionMapper.getAllRole_Permission();
        return role_permissionList;
    }
    //根据rPId删除角色所拥有的权限

    @Override
    public void deleteRolePermissionById(String rPId) {
        permissionMapper.deleteRolePermissionById(rPId);
    }

    //根据rPId查找role_permission对象

    @Override
    public List<RolePermission>  getRole_PermissionById(String rPId) {
        List<RolePermission> role_permissionlist  = permissionMapper.getRole_PermissionById(rPId);
        return role_permissionlist;
    }
    //根据roleId删除role_permission表中所有的权限
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
