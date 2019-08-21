package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.SClass;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {


    void insertClass(SClass sclass);




    List<SClass> listClass();
    //根据classid值删除class

    void deleteClassById(String classId);
    //根据class查找对应的class

    SClass getClassById(String classId);
    //更新班级信息

    void updateClass(SClass sClass);
    //获取所有的班级id

    List<String> listClassId();
}
