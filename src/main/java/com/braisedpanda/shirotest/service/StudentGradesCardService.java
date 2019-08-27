package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.StudentGradesCard;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentGradesCardService {
    //添加学生成绩卡
    void insertStudentGradesCard(StudentGradesCard card);

    //根据stuId查找所有的学生卡
    List<StudentGradesCard> listStudentGradesCardByStuId(String stuId);

    //根据描述和cardid查找学生成绩卡
    StudentGradesCard getGradesCardById_and_DesCribe(String stuId, String timeDescribe);


}
