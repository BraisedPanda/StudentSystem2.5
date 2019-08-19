package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class UserRole implements Serializable {
    private String uRId;

    private int uid;
    private String username;
    private String roleId;
    private String role;
    private String roleDescribe;

    public String getuRId() {
        return uRId;
    }

    public void setuRId(String uRId) {
        this.uRId = uRId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
