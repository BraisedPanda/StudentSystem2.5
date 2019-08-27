package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="studentgradescard")
public class StudentGradesCard implements Serializable {
    private static final long serialVersionUID = -2490828136272806829L;
    @Id
    @Column(name="stugradesCardId")

    private String stugradesCardId;
    @Column(name="stuId")
    private String stuId;
    @Column(name="testTime")
    private String testTime;
    @Column(name="testDescribe")
    private String testDescribe;



}
