package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.mapper.StudentGradesMapper;

import com.braisedpanda.shirotest.model.po.StudentGrades;
import com.braisedpanda.shirotest.service.StudentGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class StudentGradesServiceImpl implements StudentGradesService {
    @Autowired
    StudentGradesMapper studentGradesMapper;
    
    /** 
    * @Description: 添加学生成绩
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void insertStudentGrades(StudentGrades studentGrades) {
        studentGradesMapper.insert(studentGrades);
    }
    /** 
    * @Description: 根据id获取学生信息
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public StudentGrades getStudentGradesByCardId(String stuGradesCardId) {
        Example example = new Example(StudentGrades.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stugradesCardId",stuGradesCardId);
        StudentGrades studentGrades = studentGradesMapper.selectOneByExample(example);
        return studentGrades;
    }
    
}   
