package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="studentgradescard")
public class StudentGradesCard implements Serializable {
    @Id
    private String stugradesCardId;
    private String stuId;
    private String testTime;
    private String testDescribe;



}
