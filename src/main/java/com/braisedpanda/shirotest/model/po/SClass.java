package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
@Data
@Table(name="class")
public class SClass implements Serializable{
    private static final long serialVersionUID = -1476631663410328285L;
    @Id
    @Column(name="classId")
    private String classId;                //班级id
    @Column(name="className")
    private String className;              //班级名称
    @Column(name="classTeacher")
    private String classTeacher;           //班主任
    @Column(name="classCount")
    private Integer classCount;             //班级总人数
    @Column(name="chineseTeacher")
    private String chineseTeacher;         //语文老师
    @Column(name="mathematicsTeacher")
    private String mathematicsTeacher;     //数学老师
    @Column(name="englishTeacher")
    private String englishTeacher;         //英语老师
    @Column(name="politicsTeacher")
    private String politicsTeacher;        //政治老师
    @Column(name="historyTeacher")
    private String historyTeacher;         //历史老师
    @Column(name="geographyTeacher")
    private String geographyTeacher;       //地理老师
    @Column(name="biologyTeacher")
    private String biologyTeacher;         //生物老师
    @Column(name="chemistryTeacher")
    private String chemistryTeacher;       //化学老师
    @Column(name="physicsTeacher")
    private String physicsTeacher;         //物理老师
    @Column(name="musicTeacher")
    private String musicTeacher;           //音乐老师
    @Column(name="artsTeacher")
    private String artsTeacher;            //美术老师
    @Column(name="sportsTeacher")
    private String sportsTeacher;          //体育老师



}
