package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.bean.po.SClass;
import com.braisedpanda.shirotest.mapper.ClassMapper;
import com.braisedpanda.shirotest.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;
    @Override
    public void insertClass(SClass sclass) {
        classMapper.insertClass(sclass);
    }

    @Override
    public List<SClass> listClass() {
        List<SClass> classList = classMapper.listClass();
        return classList;
    }
    //根据classid值删除class

    @Override
    public void deleteClassById(String classId) {
        classMapper.deleteClassById(classId);
    }
    //根据classid查找出对应的class

    @Override
    public SClass getClassById(String classId) {
        SClass sClass = classMapper.getClassById(classId);
        return sClass;
    }

    //更新班级信息
     @Override
    public void updateClass(SClass sClass) {
        classMapper.updateClass(sClass);
    }


    ////获取所有的班级id


    @Override
    public List<String> listClassId() {
        List<String> list =  classMapper.listClassId();
        return list;
    }
}
