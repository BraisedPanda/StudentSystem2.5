package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.model.po.ClassGrades;
import com.braisedpanda.shirotest.model.po.ClassGradesCard;
import com.braisedpanda.shirotest.model.po.StudentGradesCard;
import com.braisedpanda.shirotest.model.vo.StudentGradesCustomVO;
import com.braisedpanda.shirotest.mapper.GradesMapper;
import com.braisedpanda.shirotest.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesServiceImpl implements GradesService {
    @Autowired
    GradesMapper gradesMapper;





    @Override
    public List<StudentGradesCustomVO> getStuGradesBystuId(String stuId) {
        List<StudentGradesCustomVO> sgcList = gradesMapper.getStuGradesBystuId(stuId);

        return sgcList;
    }

    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
     @Override
    public List<StudentGradesCard> getSGCard() {
         List<StudentGradesCard> list =  gradesMapper.getSGCard();
         return list;
    }










}
