package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="classgrades")
public class ClassGrades implements Serializable{
    @Id
    @Column(name="classGradesId")
    private String classGradesId;      //classGradesId
    @Column(name="classGradesCardId")
    private String classGradesCardId; //根据classGradesCardId，作为查找入口
    @Column(name="totalAve")
    private double totalAve;             //各项班级总分、平均分、最低分、最高分
    @Column(name="totalMax")
    private double totalMax;        //测试上传2019-8-19 21:19:26
    @Column(name="totalMin")
    private double totalMin;
    @Column(name="chineseMax")
    private double chineseMax;
    @Column(name="chineseMin")
    private double chineseMin;
    @Column(name="chineseAve")
    private double chineseAve;
    @Column(name="mathematicsMin")
    private double mathematicsMin;
    @Column(name="mathematicsMax")
    private double mathematicsMax;
    @Column(name="mathematicsAve")
    private double mathematicsAve;
    @Column(name="englishMax")
    private double englishMax;
    @Column(name="englishMin")
    private double englishMin;
    @Column(name="englishAve")
    private double englishAve;
    @Column(name="politicsMin")
    private double politicsMin;
    @Column(name="politicsMax")
    private double politicsMax;
    @Column(name="politicsAve")
    private double politicsAve;
    @Column(name="historyMax")
    private double historyMax;
    @Column(name="historyMin")
    private double historyMin;
    @Column(name="historyAve")
    private double historyAve;
    @Column(name="geographyMin")
    private double geographyMin;
    @Column(name="geographyAve")
    private double geographyAve;
    @Column(name="geographyMax")
    private double geographyMax;
    @Column(name="biologyMax")
    private double biologyMax;
    @Column(name="biologyMin")
    private double biologyMin;
    @Column(name="biologyAve")
    private double biologyAve;
    @Column(name="chemistryMin")
    private double chemistryMin;
    @Column(name="chemistryAve")
    private double chemistryAve;
    @Column(name="chemistryMax")
    private double chemistryMax;
    @Column(name="physicsMin")
    private double physicsMin;
    @Column(name="physicsAve")
    private double physicsAve;
    @Column(name="physicsMax")
    private double physicsMax;
    @Column(name="musicMin")
    private double musicMin;
    @Column(name="musicAve")
    private double musicAve;
    @Column(name="musicMax")
    private double musicMax;
    @Column(name="artsMin")
    private double artsMin;
    @Column(name="artsAve")
    private double artsAve;
    @Column(name="artsMax")
    private double artsMax;
    @Column(name="sportsMin")
    private double sportsMin;
    @Column(name="sportsMax")
    private double sportsMax;
    @Column(name="sportsAve")
    private double sportsAve;


}
