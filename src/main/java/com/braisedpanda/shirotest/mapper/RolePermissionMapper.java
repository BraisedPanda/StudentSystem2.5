package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.model.po.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionMapper extends tk.mybatis.mapper.common.Mapper<RolePermission>{

    List<String> getPermission(String uid);
}
