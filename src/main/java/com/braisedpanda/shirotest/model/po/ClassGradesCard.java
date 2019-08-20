package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="classgradescard")
public class ClassGradesCard implements Serializable{
    @Id
    private String classGradesCardId;
    private String classId;
    private String testTime;
    private String testDescribe;


    }

