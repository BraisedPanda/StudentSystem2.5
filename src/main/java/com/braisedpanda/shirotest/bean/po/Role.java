package com.braisedpanda.shirotest.bean.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class Role implements Serializable{
    private String roleId;
    private String role;
    private String roleDescribe;


}
