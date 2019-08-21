package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="nation")
public class Nation implements Serializable{
    @Id
    @Column(name="nationId")
    private String nationId;
    @Column(name="nationName")
    private String nationName;


}
