package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="studentgrades")
public class StudentGrades implements Serializable{
    @Id
    @Column(name="stugradesId")

    private String stugradesId;
    @Column(name="stugradesCardId")
    private String stugradesCardId;
    @Column(name="total")
    private double total;
    @Column(name="average")
    private double average;
    @Column(name="maxScore")
    private double maxScore;
    @Column(name="minScore")
    private double minScore;
    @Column(name="chinese")
    private double chinese;
    @Column(name="mathematics")
    private double mathematics;
    @Column(name="english")
    private double english;
    @Column(name="politics")
    private double politics;
    @Column(name="history")
    private double history;
    @Column(name="geography")
    private double geography;
    @Column(name="biology")
    private double biology;
    @Column(name="chemistry")
    private double chemistry;
    @Column(name="physics")
    private double physics;
    @Column(name="music")
    private double music;
    @Column(name="arts")
    private double arts;
    @Column(name="sports")
    private double sports;


}
