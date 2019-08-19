package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradesMapper {


    void add(StudentGradesCard card);

    List<StudentGradesCard> getGradesCard(String stuId);

    void addGrades(StudentGrades student_grades);

    StudentGrades getGrades(String stugradesCardId);

    List<StudentGradesCustom> getStuGradesBystuId(String stuId);
    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
    List<StudentGradesCard> getSGCard();
    //批量生成学生成绩卡
    void addClassGradesCard(ClassGradesCard cgcrad);
    //获取所有的班级成绩卡
    List<ClassGradesCard> getAllClassGradesCard();

    StudentGradesCard getGradesCardById_and_DesCribe(@Param("stuId") String stuId, @Param("testDescribe") String time_describe);

    void addClassGrades(ClassGrades ClassGrades);
    //查找所有的班级成绩
    List<ClassGrades> getAllClassGrades();
    //根据id查找班级成绩卡
    ClassGradesCard getClassGradesCardByID(String classGradesCardId);
}
