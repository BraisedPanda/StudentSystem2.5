package com.braisedpanda.shirotest.bean.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class RolePermission implements Serializable{
    private String rPId;
    private String permissionId;
    private String permission;
    private String permissionDescribe;
    private String roleId;
    private String role;
    private String roleDescribe;


}
