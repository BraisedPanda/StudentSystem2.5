package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="nation")
public class Nation implements Serializable{
    @Id
    private String nationId;
    private String nationName;


}
