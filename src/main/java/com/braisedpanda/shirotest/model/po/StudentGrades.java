package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="studentgrades")
public class StudentGrades implements Serializable{
    @Id
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
