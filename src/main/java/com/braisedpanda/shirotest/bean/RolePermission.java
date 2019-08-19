package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class RolePermission implements Serializable{
    private String rPId;
    private String nationName;
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

    public String getnationName() {
        return nationName;
    }

    public void setnationName(String nationName) {
        this.nationName = nationName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getpermissionDescribe() {
        return permissionDescribe;
    }

    public void setpermissionDescribe(String permissionDescribe) {
        this.permissionDescribe = permissionDescribe;
    }

    public String getroleId() {
        return roleId;
    }

    public void setroleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getroleDescribe() {
        return roleDescribe;
    }

    public void setroleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "rPId='" + rPId + '\'' +
                ", nationName='" + nationName + '\'' +
                ", permission='" + permission + '\'' +
                ", permissionDescribe='" + permissionDescribe + '\'' +
                ", roleId='" + roleId + '\'' +
                ", role='" + role + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                '}';
    }
}
