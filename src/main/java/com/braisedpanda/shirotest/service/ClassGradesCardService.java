package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.ClassGrades;
import com.braisedpanda.shirotest.model.po.ClassGradesCard;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClassGradesCardService {

    //获取所有的班级成绩卡片
    List<ClassGradesCard> listClassGradesCard();

    //批量生成学生成绩卡
    void insertClassGradesCard(ClassGradesCard cgcrad);

    //根据id查找班级成绩卡
    ClassGradesCard getClassGradesCardByID(String classGradesCardId);
}
