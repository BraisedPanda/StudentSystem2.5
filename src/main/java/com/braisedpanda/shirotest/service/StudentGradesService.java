package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.StudentGrades;
import org.springframework.stereotype.Service;


public interface StudentGradesService {

    //插入学生成绩
    void insertStudentGrades(StudentGrades studentGrades);

    //根据id查询学生成绩
    StudentGrades getStudentGradesByCardId(String stugradesCardId);

}
