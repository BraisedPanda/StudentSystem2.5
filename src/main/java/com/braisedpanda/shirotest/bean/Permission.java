package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Permission implements Serializable {

    private String nationName;
    private String permission;
    private String permissionDescribe;

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


    @Override
    public String toString() {
        return "Permission{" +
                "nationName='" + nationName + '\'' +
                ", permission='" + permission + '\'' +
                ", permissionDescribe='" + permissionDescribe + '\'' +
                '}';
    }


}
