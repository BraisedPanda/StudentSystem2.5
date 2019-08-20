package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="userrole")
public class UserRole implements Serializable {
    @Id
    private String uRId;

    private int uid;
    private String username;
    private String roleId;
    private String role;
    private String roleDescribe;


}
