package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GradesService {
    @CacheEvict(value="grades",allEntries = true,key="'add:'+#card.stugradesCardId")
    void add(StudentGradesCard card);

    @Cacheable(value = "grades" , key="'getGradesCard:'+#stuId")
    List<StudentGradesCard> getGradesCard(String stuId);
    @CacheEvict(value="grades",allEntries = true , key="'insertGrades:'+#studentGrades.stugradesId")
    void insertGrades(StudentGrades studentGrades);

    @Cacheable(value = "grades" , key="'getGrades:'+#stugradesCardId")
    StudentGrades getGrades(String stugradesCardId);

    @Cacheable(value = "grades" , key="'getStuGradesBystuId:'+#stuId")
    List<StudentGradesCustom> getStuGradesBystuId(String stuId);
    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
    List<StudentGradesCard> getSGCard();
    //批量生成学生成绩卡
    void insertClassGradesCard(ClassGradesCard cgcrad);
    //获取所有的班级成绩卡片
    @Cacheable(value="grades")
    List<ClassGradesCard> listClassGradesCard();

    StudentGradesCard getGradesCardById_and_DesCribe(String stuId, String time_describe);

    void insertClassGrades(ClassGrades ClassGrades);
    //查找所有的班级成绩
    List<ClassGrades>  listClassGrades();
    //根据id查找班级成绩卡
    ClassGradesCard getClassGradesCardByID(String classGradesCardId);
}
