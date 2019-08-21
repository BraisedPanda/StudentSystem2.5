package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name="user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    @Column(name="uid")
    private int uid;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="birthday")
    private String birthday;
    @Column(name="gender")
    private String gender;
    @Column(name="activeCode")
    private String activeCode;
    @Column(name="images")
    private String images;
    @Transient
    private String roleList;


}
