package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.mapper.ClassGradesMapper;
import com.braisedpanda.shirotest.model.po.ClassGrades;
import com.braisedpanda.shirotest.service.ClassGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGradesServiceImpl implements ClassGradesService {
    @Autowired
    ClassGradesMapper classGradesMapper;

    /**
    * @Description: 统计出所有班级成绩的数目
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */
    @Override
    public int countClassGrades() {
        ClassGrades cg = new ClassGrades();
        int count = classGradesMapper.selectCount(cg);
        return count;
    }
    
    /** 
    * @Description: 查找所有班级的成绩
    * @Param:  
    * @return: 
    * @Date: 2019/8/26 0026 
    */ 
    @Override
    public List<ClassGrades> listClassGrades() {
        List<ClassGrades> list = classGradesMapper.selectAll();
        return list;
    }

    /**
    * @Description: 插入班级成绩
    * @Param:
    * @return:
    * @Date: 2019/8/27 0027
    */
    @Override
    public void insertClassGrades(ClassGrades ClassGrades) {
        classGradesMapper.insert(ClassGrades);
    }




}
