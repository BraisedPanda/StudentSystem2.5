package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Student implements Serializable {

    private String stuId;              //学生学号
    private String stuName;            //姓名
    private String stuPassword;        //密码
    private String stuEmail;           //邮箱
    private String stuIdCard;         //身份证号码
    private String stuSex;             //性别
    private String stuBirthday;        //生日
    private String nationName;           //名族
    private String stuStatus;          //入学状态
    private String stuAge;             //年龄
    private String classId;            //班级标号
    private String stuenRollmentTime; //入学时间
    private String stuPolitical;       //政治面貌
    private String stuAddress;         //家庭住址
    private String stuImage;           //相片



    private Nation nation;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuIdCard() {
        return stuIdCard;
    }

    public void setStuIdCard(String stuIdCard) {
        this.stuIdCard = stuIdCard;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStuenRollmentTime() {
        return stuenRollmentTime;
    }

    public void setStuenRollmentTime(String stuenRollmentTime) {
        this.stuenRollmentTime = stuenRollmentTime;
    }

    public String getStuPolitical() {
        return stuPolitical;
    }

    public void setStuPolitical(String stuPolitical) {
        this.stuPolitical = stuPolitical;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuImage() {
        return stuImage;
    }

    public void setStuImage(String stuImage) {
        this.stuImage = stuImage;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
