package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Permission;
import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.RolePermission;
import com.braisedpanda.shirotest.bean.UserRole;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PermissionService {
    @CacheEvict(value="permission",key="'addRole:'+#role.roleId")
    void addRole(Role role);
    //获取所有的权限

    List<Permission> getAllPermission();

    //根据权限的id值，查询对应的权限
    @Cacheable(value="permission" , key="'getPermissionById:'+#s1")
    Permission getPermissionById(String s1);

    //添加对应的角色-权限表
    @CacheEvict(value="permission", key="'addRole_Permission:'+#rp.rPId")
    void addRole_Permission(RolePermission rp);

    //查找所有的角色

    List<Role> getAllRole();
    //根据uid查找所有的角色
    @Cacheable(value = "permission" , key="'getRoleById:'+#uid")
    List<UserRole> getRoleById(String uid);
    //根据roleId查询role表中对应的role
    @Cacheable(value="permission" , key="'getRoleByroleId:'+#roleId")
    Role getRoleByroleId(String roleId);
    //新增user_role信息
    @CacheEvict(value="permission", key="'addUser_Role:'+#user_role.u_r_id")
    void addUser_Role(UserRole user_role);
    //删除user_role表中所有uid用户
    @CacheEvict(value="permission", key="'deleteRoleByUid:'+#uid",allEntries = true)
    void deleteRoleByUid(int uid);
    //查找所有的role_permission内容

    List<RolePermission> getAllRole_Permission();
    //根据rPId删除角色所拥有的权限
    @CacheEvict(value="permission", key="'deleteRolePermissionById:'+#rPId",allEntries = true)
    void deleteRolePermissionById(String rPId);

    //根据rPId查找role_permission对象
    @Cacheable(value = "permission" , key="'getRole_PermissionById:'+#rPId")
    List<RolePermission>  getRole_PermissionById(String rPId);
    //根据roleId删除role_permission表中所有的权限
    @CacheEvict(value="permission", key="'deleteRolePermissionByroleId:'+#roleId",allEntries = true)
    void deleteRolePermissionByroleId(String roleId);
    //在role表中更新role的相关权限、名称等信息
    @CacheEvict(value="permission", key="'updateRole:'+#role.roleId",allEntries = true)
    void updateRole(Role role);
    //根据roleId删除role表中的role
    @CacheEvict(value="permission" , key="'deleteRoleByroleId:'+#roleId")
    void deleteRoleByroleId(String roleId);
}
