package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name="users")
public class User implements Serializable{
    private static final long serialVersionUID = -700577685605456958L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    @Column(name="userid")
    private Integer userid;
    @Column(name="username")
    private String username;
    @Column(name="userpassword")
    private String userpassword;
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



}
