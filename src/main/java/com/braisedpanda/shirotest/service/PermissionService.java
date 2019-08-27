package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.Permission;
import com.braisedpanda.shirotest.model.po.Role;
import com.braisedpanda.shirotest.model.po.RolePermission;
import com.braisedpanda.shirotest.model.po.UserRole;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PermissionService {


    //获取所有的权限
    List<Permission> selecAllPermission();

    //根据权限的id值，查询对应的权限
    Permission getPermissionById(String permissionId);










}
