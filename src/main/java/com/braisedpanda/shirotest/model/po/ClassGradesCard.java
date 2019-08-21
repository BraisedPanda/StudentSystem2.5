package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="classgradescard")
public class ClassGradesCard implements Serializable{
    @Id
    @Column(name="classGradesCardId")
    private String classGradesCardId;
    @Column(name="classId")
    private String classId;
    @Column(name="testTime")
    private String testTime;
    @Column(name="testDescribe")
    private String testDescribe;


    }

