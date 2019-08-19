package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class RolePermission implements Serializable{
    private String rPId;
    private String permissionId;
    private String permission;
    private String permissionDescribe;
    private String roleId;
    private String role;
    private String roleDescribe;

    public String getrPId() {
        return rPId;
    }

    public void setrPId(String rPId) {
        this.rPId = rPId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermissionDescribe() {
        return permissionDescribe;
    }

    public void setPermissionDescribe(String permissionDescribe) {
        this.permissionDescribe = permissionDescribe;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }
}
