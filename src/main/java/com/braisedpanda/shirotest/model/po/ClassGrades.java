package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="classgrades")
public class ClassGrades implements Serializable{

    private static final long serialVersionUID = 1536811172206548570L;
    @Id
    @Column(name="classGradesId")
    private String classGradesId;      //classGradesId
    @Column(name="classGradesCardId")
    private String classGradesCardId; //根据classGradesCardId，作为查找入口
    @Column(name="totalAve")
    private Double totalAve;             //各项班级总分、平均分、最低分、最高分
    @Column(name="totalMax")
    private Double totalMax;
    @Column(name="totalMin")
    private Double totalMin;
    @Column(name="chineseMax")
    private Double chineseMax;
    @Column(name="chineseMin")
    private Double chineseMin;
    @Column(name="chineseAve")
    private Double chineseAve;
    @Column(name="mathematicsMin")
    private Double mathematicsMin;
    @Column(name="mathematicsMax")
    private Double mathematicsMax;
    @Column(name="mathematicsAve")
    private Double mathematicsAve;
    @Column(name="englishMax")
    private Double englishMax;
    @Column(name="englishMin")
    private Double englishMin;
    @Column(name="englishAve")
    private Double englishAve;
    @Column(name="politicsMin")
    private Double politicsMin;
    @Column(name="politicsMax")
    private Double politicsMax;
    @Column(name="politicsAve")
    private Double politicsAve;
    @Column(name="historyMax")
    private Double historyMax;
    @Column(name="historyMin")
    private Double historyMin;
    @Column(name="historyAve")
    private Double historyAve;
    @Column(name="geographyMin")
    private Double geographyMin;
    @Column(name="geographyAve")
    private Double geographyAve;
    @Column(name="geographyMax")
    private Double geographyMax;
    @Column(name="biologyMax")
    private Double biologyMax;
    @Column(name="biologyMin")
    private Double biologyMin;
    @Column(name="biologyAve")
    private Double biologyAve;
    @Column(name="chemistryMin")
    private Double chemistryMin;
    @Column(name="chemistryAve")
    private Double chemistryAve;
    @Column(name="chemistryMax")
    private Double chemistryMax;
    @Column(name="physicsMin")
    private Double physicsMin;
    @Column(name="physicsAve")
    private Double physicsAve;
    @Column(name="physicsMax")
    private Double physicsMax;
    @Column(name="musicMin")
    private Double musicMin;
    @Column(name="musicAve")
    private Double musicAve;
    @Column(name="musicMax")
    private Double musicMax;
    @Column(name="artsMin")
    private Double artsMin;
    @Column(name="artsAve")
    private Double artsAve;
    @Column(name="artsMax")
    private Double artsMax;
    @Column(name="sportsMin")
    private Double sportsMin;
    @Column(name="sportsMax")
    private Double sportsMax;
    @Column(name="sportsAve")
    private Double sportsAve;


}
