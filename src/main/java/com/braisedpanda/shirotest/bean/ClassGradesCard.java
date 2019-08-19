package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class ClassGradesCard implements Serializable{
    private String classGradesCardId;
    private String classId;
    private String testTime;
    private String testDescribe;

    public String getclassGradesCardId() {
        return classGradesCardId;
    }

    public void setclassGradesCardId(String classGradesCardId) {
        this.classGradesCardId = classGradesCardId;
    }

    public String getclassId() {
        return classId;
    }

    public void setclassId(String classId) {
        this.classId = classId;
    }

    public String gettestTime() {
        return testTime;
    }

    public void settestTime(String testTime) {
        this.testTime = testTime;
    }

    public String gettestDescribe() {
        return testDescribe;
    }

    public void settestDescribe(String testDescribe) {
        this.testDescribe = testDescribe;
    }

    @Override
    public String toString() {
        return "ClassGradesCard{" +
                "classGradesCardId='" + classGradesCardId + '\'' +
                ", classId='" + classId + '\'' +
                ", testTime='" + testTime + '\'' +
                ", testDescribe='" + testDescribe + '\'' +
                '}';
    }
}
