package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.Permission;
import com.braisedpanda.shirotest.model.po.Role;
import com.braisedpanda.shirotest.model.po.RolePermission;
import com.braisedpanda.shirotest.model.po.UserRole;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService {

    void insertRole(Role role);
    //获取所有的权限

    List<Permission> getAllPermission();

    //根据权限的id值，查询对应的权限

    Permission getPermissionById(String s1);

    //添加对应的角色-权限表

    void insertRolePermission(RolePermission rp);

    //查找所有的角色

    List<Role> getAllRole();
    //根据uid查找所有的角色

    List<UserRole> getRoleById(String uid);
    //根据roleId查询role表中对应的role

    Role getRoleByroleId(String roleId);
    //新增userRole信息

    void insertUserRole(UserRole userRole);
    //删除userRole表中所有uid用户

    void deleteRoleByUid(int uid);
    //查找所有的rolePermission内容

    List<RolePermission> listRolePermission();
    //根据rPId删除角色所拥有的权限

    void deleteRolePermissionById(String rPId);

    //根据rPId查找rolePermission对象

    List<RolePermission>  getRolePermissionById(String rPId);
    //根据roleId删除rolePermission表中所有的权限

    void deleteRolePermissionByroleId(String roleId);
    //在role表中更新role的相关权限、名称等信息

    void updateRole(Role role);
    //根据roleId删除role表中的role

    void deleteRoleByroleId(String roleId);
}
