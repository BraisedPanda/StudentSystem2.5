package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleService {
    //根据uid查找所有的UserRole
    List<UserRole> selectUserRoleByUid(int uid);
}
