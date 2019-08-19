package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class ClassGradesCard implements Serializable{
    private String classGradesCardId;
    private String classId;
    private String testTime;
    private String testDescribe;

    public String getClassGradesCardId() {
        return classGradesCardId;
    }

    public void setClassGradesCardId(String classGradesCardId) {
        this.classGradesCardId = classGradesCardId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getTestDescribe() {
        return testDescribe;
    }

    public void setTestDescribe(String testDescribe) {
        this.testDescribe = testDescribe;
    }
}
