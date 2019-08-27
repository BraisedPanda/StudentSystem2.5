package com.braisedpanda.shirotest.service;


import com.braisedpanda.shirotest.model.po.ClassGrades;

import java.util.List;

public interface ClassGradesService {

    //统计出所有班级成绩的数目
    int countClassGrades();
    //统计出所有班级成绩
    List<ClassGrades> listClassGrades();

    //插入班级成绩
    void insertClassGrades(ClassGrades ClassGrades);
}
