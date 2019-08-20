package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
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


}
