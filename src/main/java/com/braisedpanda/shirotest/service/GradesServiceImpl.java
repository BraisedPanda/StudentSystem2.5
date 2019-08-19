package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.mapper.GradesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradesServiceImpl implements GradesService{
    @Autowired
    GradesMapper gradesMapper;

    @Override
    public void add(StudentGradesCard card) {
        gradesMapper.add(card);
    }

    @Override
    public List<StudentGradesCard> getGradesCard(String stuId) {
        List<StudentGradesCard> cardList = gradesMapper.getGradesCard(stuId);
        return cardList;

    }

    @Override
    public void addGrades(StudentGrades student_grades) {
        gradesMapper.addGrades(student_grades);
    }

    @Override
    public StudentGrades getGrades(String stugradesCardId) {
        StudentGrades student_grades = gradesMapper.getGrades(stugradesCardId);
        return student_grades;
    }

    @Override
    public List<StudentGradesCustom> getStuGradesBystuId(String stuId) {
        List<StudentGradesCustom> sgcList = gradesMapper.getStuGradesBystuId(stuId);

        return sgcList;
    }

    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
     @Override
    public List<StudentGradesCard> getSGCard() {
         List<StudentGradesCard> list =  gradesMapper.getSGCard();
         return list;
    }

    //批量生成学生成绩卡
    @Override
    public void addClassGradesCard(ClassGradesCard cgcrad) {
        gradesMapper.addClassGradesCard(cgcrad);
    }


    //获取所有的班级成绩卡


    @Override
    public List<ClassGradesCard> getAllClassGradesCard() {
        List<ClassGradesCard> list = gradesMapper.getAllClassGradesCard();
        return list;
    }


    @Override
    public StudentGradesCard getGradesCardById_and_DesCribe(String stuId, String time_describe) {
        StudentGradesCard card = gradesMapper.getGradesCardById_and_DesCribe(stuId,time_describe);

        return card;
    }

    @Override
    public void addClassGrades(ClassGrades ClassGrades) {
        gradesMapper.addClassGrades(ClassGrades);
    }

    //查找所有的班级成绩

    @Override
    public List<ClassGrades> getAllClassGrades() {
        List<ClassGrades> list = gradesMapper.getAllClassGrades();
        return list;
    }
    //根据id查找班级成绩卡

    @Override
    public ClassGradesCard getClassGradesCardByID(String classGradesCardId) {
       ClassGradesCard card =  gradesMapper.getClassGradesCardByID(classGradesCardId);
        return card;
    }
}
