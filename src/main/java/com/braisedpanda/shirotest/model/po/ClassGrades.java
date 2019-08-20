package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassGrades implements Serializable{
    private String classGradesId;      //classGradesId
    private String classGradesCardId; //根据classGradesCardId，作为查找入口
    private double totalAve;             //各项班级总分、平均分、最低分、最高分
    private double totalMax;        //测试上传2019-8-19 21:19:26
    private double totalMin;
    private double chineseMax;
    private double chineseMin;
    private double chineseAve;
    private double mathematicsMin;
    private double mathematicsMax;
    private double mathematicsAve;
    private double englishMax;
    private double englishMin;
    private double englishAve;
    private double politicsMin;
    private double politicsMax;
    private double politicsAve;
    private double historyMax;
    private double historyMin;
    private double historyAve;
    private double geographyMin;
    private double geographyAve;
    private double geographyMax;
    private double biologyMax;
    private double biologyMin;
    private double biologyAve;
    private double chemistryMin;
    private double chemistryAve;
    private double chemistryMax;
    private double physicsMin;
    private double physicsAve;
    private double physicsMax;
    private double musicMin;
    private double musicAve;
    private double musicMax;
    private double artsMin;
    private double artsAve;
    private double artsMax;
    private double sportsMin;
    private double sportsMax;
    private double sportsAve;


}
