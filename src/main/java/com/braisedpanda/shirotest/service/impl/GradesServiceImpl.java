package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.mapper.GradesMapper;
import com.braisedpanda.shirotest.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesServiceImpl implements GradesService {
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
    public void insertGrades(StudentGrades studentGrades) {
        gradesMapper.insertGrades(studentGrades);
    }

    @Override
    public StudentGrades getGrades(String stugradesCardId) {
        StudentGrades studentGrades = gradesMapper.getGrades(stugradesCardId);
        return studentGrades;
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
    public void insertClassGradesCard(ClassGradesCard cgcrad) {
        gradesMapper.insertClassGradesCard(cgcrad);
    }


    //获取所有的班级成绩卡


    @Override
    public List<ClassGradesCard> listClassGradesCard() {
        List<ClassGradesCard> list = gradesMapper.listClassGradesCard();
        return list;
    }


    @Override
    public StudentGradesCard getGradesCardById_and_DesCribe(String stuId, String time_describe) {
        StudentGradesCard card = gradesMapper.getGradesCardById_and_DesCribe(stuId,time_describe);

        return card;
    }

    @Override
    public void insertClassGrades(ClassGrades ClassGrades) {
        gradesMapper.insertClassGrades(ClassGrades);
    }

    //查找所有的班级成绩

    @Override
    public List<ClassGrades> listClassGrades() {
        List<ClassGrades> list = gradesMapper.listClassGrades();
        return list;
    }
    //根据id查找班级成绩卡

    @Override
    public ClassGradesCard getClassGradesCardByID(String classGradesCardId) {
       ClassGradesCard card =  gradesMapper.getClassGradesCardByID(classGradesCardId);
        return card;
    }
}
