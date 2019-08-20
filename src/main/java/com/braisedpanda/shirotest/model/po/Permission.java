package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="permission")
public class Permission implements Serializable {
    @Id
    private String permissionId;
    private String permission;
    private String permissionDescribe;
}


