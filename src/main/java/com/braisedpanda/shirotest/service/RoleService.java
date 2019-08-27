package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.Role;
import com.braisedpanda.shirotest.model.po.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    //添加角色
    void insertRole(Role role);

    //查找所有的角色
    List<Role> selectAllRole();

    //根据roleId查询role表中对应的role
    Role getRoleById(Role role);

    //在role表中更新role的相关权限、名称等信息
    void updateRole(Role role);

    //根据roleId删除role表中的role
    void deleteRoleByroleId(Role role);

    //统计出role表中所有的数目
    int countRole();
}
