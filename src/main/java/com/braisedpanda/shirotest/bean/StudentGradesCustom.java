package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class StudentGradesCustom implements Serializable {

    /**
     * 学生成绩信息表
     */

    private String stuId;
    private String stuName;
    private String classId;
    private String testDescribe;
    private String testTime;
    private double total;
    private double average;
    private double maxScore;
    private double minScore;
    private double chinese;
    private double mathematics;
    private double english;
    private double politics;
    private double history;
    private double geography;
    private double biology;
    private double chemistry;
    private double physics;
    private double music;
    private double arts;
    private double sports;

    public String gettestTime() {
        return testTime;
    }

    public void settestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getstuId() {
        return stuId;
    }

    public void setstuId(String stuId) {
        this.stuId = stuId;
    }

    public String getstuName() {
        return stuName;
    }

    public void setstuName(String stuName) {
        this.stuName = stuName;
    }

    public String getclassId() {
        return classId;
    }

    public void setclassId(String classId) {
        this.classId = classId;
    }

    public String gettestDescribe() {
        return testDescribe;
    }

    public void settestDescribe(String testDescribe) {
        this.testDescribe = testDescribe;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getmaxScore() {
        return maxScore;
    }

    public void setmaxScore(double maxScore) {
        this.maxScore = maxScore;
    }

    public double getminScore() {
        return minScore;
    }

    public void setminScore(double minScore) {
        this.minScore = minScore;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMathematics() {
        return mathematics;
    }

    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getPolitics() {
        return politics;
    }

    public void setPolitics(double politics) {
        this.politics = politics;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getGeography() {
        return geography;
    }

    public void setGeography(double geography) {
        this.geography = geography;
    }

    public double getBiology() {
        return biology;
    }

    public void setBiology(double biology) {
        this.biology = biology;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getMusic() {
        return music;
    }

    public void setMusic(double music) {
        this.music = music;
    }

    public double getArts() {
        return arts;
    }

    public void setArts(double arts) {
        this.arts = arts;
    }

    public double getSports() {
        return sports;
    }

    public void setSports(double sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "StudentGradesCustom{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", classId='" + classId + '\'' +
                ", testDescribe='" + testDescribe + '\'' +
                ", testTime='" + testTime + '\'' +
                ", total=" + total +
                ", average=" + average +
                ", maxScore=" + maxScore +
                ", minScore=" + minScore +
                ", chinese=" + chinese +
                ", mathematics=" + mathematics +
                ", english=" + english +
                ", politics=" + politics +
                ", history=" + history +
                ", geography=" + geography +
                ", biology=" + biology +
                ", chemistry=" + chemistry +
                ", physics=" + physics +
                ", music=" + music +
                ", arts=" + arts +
                ", sports=" + sports +
                '}';
    }
}
