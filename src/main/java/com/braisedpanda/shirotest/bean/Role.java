package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Role implements Serializable{
    private String roleId;
    private String role;
    private String roleDescribe;

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
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", role='" + role + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                '}';
    }
}
