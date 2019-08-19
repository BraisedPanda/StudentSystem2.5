package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class UserRole implements Serializable {
    private String u_r_id;

    private int uid;
    private String username;
    private String roleId;
    private String role;
    private String roleDescribe;

    public String getroleDescribe() {
        return roleDescribe;
    }

    public void setroleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    public String getU_r_id() {
        return u_r_id;
    }

    public void setU_r_id(String u_r_id) {
        this.u_r_id = u_r_id;
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


    @Override
    public String toString() {
        return "UserRole{" +
                "u_r_id='" + u_r_id + '\'' +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", roleId='" + roleId + '\'' +
                ", role='" + role + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                '}';
    }
}
