package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Permission;
import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.RolePermission;
import com.braisedpanda.shirotest.bean.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    //添加角色
    void addRole(Role role);
    //查询所有的权限信息
    List<Permission> getAllPermission();
    //根据权限id查出对应的权限
    Permission getPermissionById(String s1);
    //添加对应的角色-权限表
    void addRole_Permission(RolePermission rp);
    //得到所有的角色
    List<Role> getAllRole();
    //根据uid查找出所有的角色
    List<UserRole> getRoleById(String uid);
    //根据roleId在表role中查询相应的role
    Role getRoleByroleId(String roleId);
    //新增user_role信息
    void addUser_Role(UserRole user_role);
    //在表user_role中删除所有uid的角色
    void deleteRoleByUid(int uid);
    //查找所有的role_permission内容
    List<RolePermission> getAllRole_Permission();
    //根据rPId删除角色所拥有的权限
    void deleteRolePermissionById(String rPId);
    //根据rPId查找role_permission对象
    List<RolePermission> getRole_PermissionById(String rPId);

    //根据roleId删除role_permission表中所有的权限
    void deleteRolePermissionByroleId(String roleId);
    //在role表中更新role的相关权限、名称等信息
    void updateRole(Role role);
    //根据roleId删除role表中的role
    void deleteRoleByroleId(String roleId);
}
