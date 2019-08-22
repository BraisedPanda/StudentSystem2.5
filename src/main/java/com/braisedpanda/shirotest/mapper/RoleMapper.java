package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.model.po.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends tk.mybatis.mapper.common.Mapper<Role> {

    //添加角色
//    void insertRole(Role role);

}
