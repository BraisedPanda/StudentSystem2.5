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


    public String getnationName() {
        return nationName;
    }

    public void setnationName(String nationName) {
        this.nationName = nationName;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
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

    public String getstuPassword() {
        return stuPassword;
    }

    public void setstuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getstuEmail() {
        return stuEmail;
    }

    public void setstuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getstuIdCard() {
        return stuIdCard;
    }

    public void setstuIdCard(String stuIdCard) {
        this.stuIdCard = stuIdCard;
    }

    public String getstuSex() {
        return stuSex;
    }

    public void setstuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getstuBirthday() {
        return stuBirthday;
    }

    public void setstuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }





    public String getstuStatus() {
        return stuStatus;
    }

    public void setstuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public String getstuAge() {
        return stuAge;
    }

    public void setstuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getclassId() {
        return classId;
    }

    public void setclassId(String classId) {
        this.classId = classId;
    }

    public String getstuenRollmentTime() {
        return stuenRollmentTime;
    }

    public void setstuenRollmentTime(String stuenRollmentTime) {
        this.stuenRollmentTime = stuenRollmentTime;
    }

    public String getstuPolitical() {
        return stuPolitical;
    }

    public void setstuPolitical(String stuPolitical) {
        this.stuPolitical = stuPolitical;
    }

    public String getstuAddress() {
        return stuAddress;
    }

    public void setstuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getstuImage() {
        return stuImage;
    }

    public void setstuImage(String stuImage) {
        this.stuImage = stuImage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuIdCard='" + stuIdCard + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuBirthday='" + stuBirthday + '\'' +
                ", nationName='" + nationName + '\'' +
                ", stuStatus='" + stuStatus + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", classId='" + classId + '\'' +
                ", stuenRollmentTime='" + stuenRollmentTime + '\'' +
                ", stuPolitical='" + stuPolitical + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuImage='" + stuImage + '\'' +
                ", nation=" + nation +
                '}';
    }
}
