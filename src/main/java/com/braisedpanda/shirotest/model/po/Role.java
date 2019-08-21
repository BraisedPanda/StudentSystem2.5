package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="role")
public class Role implements Serializable{
    @Id
    @Column(name="roleId")
    private String roleId;
    @Column(name="role")
    private String role;
    @Column(name="roleDescribe")
    private String roleDescribe;


}
