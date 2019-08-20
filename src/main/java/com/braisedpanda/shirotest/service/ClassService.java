package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.SClass;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    @CacheEvict(value="class",key="'insertClass:'+#sclass.classId",allEntries = true)
    void insertClass(SClass sclass);





    List<SClass> listClass();
    //根据classid值删除class
    @CacheEvict(value="class" , key="'deleteClassById:'+#classId")
    void deleteClassById(String classId);
    //根据class查找对应的class
    @Cacheable(value="class" , key="'getClassById:'+#classId")
    SClass getClassById(String classId);
    //更新班级信息
    @CacheEvict(value = "class" , key="'updateClass:'+#sClass.classId")
    void updateClass(SClass sClass);
    //获取所有的班级id
    @Cacheable(value = "class")
    List<String> listClassId();
}
