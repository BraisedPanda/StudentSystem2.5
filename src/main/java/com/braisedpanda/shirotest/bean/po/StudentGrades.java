package com.braisedpanda.shirotest.bean.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class StudentGrades implements Serializable{
    private String stugradesId;
    private String stugradesCardId;
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


}
