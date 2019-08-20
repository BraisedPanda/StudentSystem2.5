package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class Permission implements Serializable {

    private String permissionId;
    private String permission;
    private String permissionDescribe;
}


