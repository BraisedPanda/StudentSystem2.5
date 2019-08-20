package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="rolepermission")
public class RolePermission implements Serializable{
    @Id
    private String rPId;
    private String permissionId;
    private String permission;
    private String permissionDescribe;
    private String roleId;
    private String role;
    private String roleDescribe;


}
