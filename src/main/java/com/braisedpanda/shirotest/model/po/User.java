package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
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
