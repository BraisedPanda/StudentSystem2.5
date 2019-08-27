package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = -4897498857041078361L;
    @Id
    @Column(name="permissionId")
    private String permissionId;
    @Column(name="permission")
    private String permission;
    @Column(name="permissionDescribe")
    private String permissionDescribe;
}


