package com.braisedpanda.shirotest.bean;

import java.io.Serializable;
import java.util.List;

public class SClass implements Serializable{
    private String classId;                //班级id
    private String className;              //班级名称
    private String classTeacher;           //班主任
    private int classCount;             //班级总人数
    private String chineseTeacher;         //语文老师
    private String mathematicsTeacher;     //数学老师
    private String englishTeacher;         //英语老师
    private String politicsTeacher;        //政治老师
    private String historyTeacher;         //历史老师
    private String geographyTeacher;       //地理老师
    private String biologyTeacher;         //生物老师
    private String chemistryTeacher;       //化学老师
    private String physicsTeacher;         //物理老师
    private String musicTeacher;           //音乐老师
    private String artsTeacher;            //美术老师
    private String sportsTeacher;          //体育老师
    private List<Student> studentList;      //班级全部的学生

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
    }

    public String getChineseTeacher() {
        return chineseTeacher;
    }

    public void setChineseTeacher(String chineseTeacher) {
        this.chineseTeacher = chineseTeacher;
    }

    public String getMathematicsTeacher() {
        return mathematicsTeacher;
    }

    public void setMathematicsTeacher(String mathematicsTeacher) {
        this.mathematicsTeacher = mathematicsTeacher;
    }

    public String getEnglishTeacher() {
        return englishTeacher;
    }

    public void setEnglishTeacher(String englishTeacher) {
        this.englishTeacher = englishTeacher;
    }

    public String getPoliticsTeacher() {
        return politicsTeacher;
    }

    public void setPoliticsTeacher(String politicsTeacher) {
        this.politicsTeacher = politicsTeacher;
    }

    public String getHistoryTeacher() {
        return historyTeacher;
    }

    public void setHistoryTeacher(String historyTeacher) {
        this.historyTeacher = historyTeacher;
    }

    public String getGeographyTeacher() {
        return geographyTeacher;
    }

    public void setGeographyTeacher(String geographyTeacher) {
        this.geographyTeacher = geographyTeacher;
    }

    public String getBiologyTeacher() {
        return biologyTeacher;
    }

    public void setBiologyTeacher(String biologyTeacher) {
        this.biologyTeacher = biologyTeacher;
    }

    public String getChemistryTeacher() {
        return chemistryTeacher;
    }

    public void setChemistryTeacher(String chemistryTeacher) {
        this.chemistryTeacher = chemistryTeacher;
    }

    public String getPhysicsTeacher() {
        return physicsTeacher;
    }

    public void setPhysicsTeacher(String physicsTeacher) {
        this.physicsTeacher = physicsTeacher;
    }

    public String getMusicTeacher() {
        return musicTeacher;
    }

    public void setMusicTeacher(String musicTeacher) {
        this.musicTeacher = musicTeacher;
    }

    public String getArtsTeacher() {
        return artsTeacher;
    }

    public void setArtsTeacher(String artsTeacher) {
        this.artsTeacher = artsTeacher;
    }

    public String getSportsTeacher() {
        return sportsTeacher;
    }

    public void setSportsTeacher(String sportsTeacher) {
        this.sportsTeacher = sportsTeacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
