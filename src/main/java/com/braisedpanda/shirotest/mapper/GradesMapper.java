package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.model.po.StudentGradesCard;
import com.braisedpanda.shirotest.model.vo.StudentGradesCustomVO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface GradesMapper {


//    void add(StudentGradesCard card);

    List<StudentGradesCustomVO> getStuGradesBystuId(String stuId);
    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
    List<StudentGradesCard> getSGCard();

}
