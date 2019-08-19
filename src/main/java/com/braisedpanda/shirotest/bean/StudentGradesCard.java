package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class StudentGradesCard implements Serializable {
    private String stugradesCardId;
    private String stuId;
    private String testTime;
    private String testDescribe;


    public String getStugradesCardId() {
        return stugradesCardId;
    }

    public void setStugradesCardId(String stugradesCardId) {
        this.stugradesCardId = stugradesCardId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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
