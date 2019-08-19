package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class StudentGradesCard implements Serializable {
    private String stugradesCardId;
    private String stuId;
    private String testTime;
    private String testDescribe;


    public String getstugradesCardId() {
        return stugradesCardId;
    }

    public void setstugradesCardId(String stugradesCardId) {
        this.stugradesCardId = stugradesCardId;
    }

    public String getstuId() {
        return stuId;
    }

    public void setstuId(String stuId) {
        this.stuId = stuId;
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
        return "StudentGradesCard{" +
                "stugradesCardId='" + stugradesCardId + '\'' +
                ", stuId='" + stuId + '\'' +
                ", testTime='" + testTime + '\'' +
                ", testDescribe='" + testDescribe + '\'' +
                '}';
    }
}
