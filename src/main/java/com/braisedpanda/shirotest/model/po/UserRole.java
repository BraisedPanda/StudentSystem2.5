package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="userrole")
public class UserRole implements Serializable {
    @Id
    @Column(name="uRId")
    private String uRId;
    @Column(name="uid")
    private int uid;
    @Column(name="username")
    private String username;
    @Column(name="roleId")
    private String roleId;
    @Column(name="role")
    private String role;
    @Column(name="roleDescribe")
    private String roleDescribe;


}
