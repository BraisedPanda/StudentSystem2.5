package com.braisedpanda.shirotest.bean.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class ClassGradesCard implements Serializable{
    private String classGradesCardId;
    private String classId;
    private String testTime;
    private String testDescribe;


    }

