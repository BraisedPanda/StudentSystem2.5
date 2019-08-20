package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class StudentGradesCard implements Serializable {
    private String stugradesCardId;
    private String stuId;
    private String testTime;
    private String testDescribe;



}
