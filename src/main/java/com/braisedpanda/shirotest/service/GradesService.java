package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.ClassGrades;
import com.braisedpanda.shirotest.model.po.ClassGradesCard;
import com.braisedpanda.shirotest.model.po.StudentGradesCard;
import com.braisedpanda.shirotest.model.vo.StudentGradesCustomVO;

import java.util.List;


public interface GradesService {




    List<StudentGradesCustomVO> getStuGradesBystuId(String stuId);

    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
    List<StudentGradesCard> getSGCard();









}
