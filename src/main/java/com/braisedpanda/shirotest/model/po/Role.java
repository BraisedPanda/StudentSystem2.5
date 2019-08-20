package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="role")
public class Role implements Serializable{
    @Id
    private String roleId;
    private String role;
    private String roleDescribe;


}
