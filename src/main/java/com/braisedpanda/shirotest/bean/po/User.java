package com.braisedpanda.shirotest.bean.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{
    private int uid;
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String gender;
    private String activeCode;
    private String images;
    private String roleList;


}
