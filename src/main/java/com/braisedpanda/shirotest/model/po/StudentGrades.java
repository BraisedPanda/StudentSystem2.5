package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="studentgrades")
public class StudentGrades implements Serializable{
    private static final long serialVersionUID = 5845985959412302322L;
    @Id
    @Column(name="stugradesId")

    private String stugradesId;
    @Column(name="stugradesCardId")
    private String stugradesCardId;
    @Column(name="total")
    private Double total;
    @Column(name="average")
    private Double average;
    @Column(name="maxScore")
    private Double maxScore;
    @Column(name="minScore")
    private Double minScore;
    @Column(name="chinese")
    private Double chinese;
    @Column(name="mathematics")
    private Double mathematics;
    @Column(name="english")
    private Double english;
    @Column(name="politics")
    private Double politics;
    @Column(name="history")
    private Double history;
    @Column(name="geography")
    private Double geography;
    @Column(name="biology")
    private Double biology;
    @Column(name="chemistry")
    private Double chemistry;
    @Column(name="physics")
    private Double physics;
    @Column(name="music")
    private Double music;
    @Column(name="arts")
    private Double arts;
    @Column(name="sports")
    private Double sports;


}
