package com.braisedpanda.shirotest.bean.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserRole implements Serializable {
    private String uRId;

    private int uid;
    private String username;
    private String roleId;
    private String role;
    private String roleDescribe;


}
