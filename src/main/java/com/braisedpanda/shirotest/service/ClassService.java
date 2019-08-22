package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.SClass;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    //添加班级
    void insertClass(SClass sclass);

    //查找出所有的班级
    List<SClass> selectAllSClass();


    //根据classid值删除class
    void deleteSClassById(SClass sClass);

    //根据classid查找对应的class
    SClass selectSClassById(SClass sClass);

    // 更新班级信息
    void updateSClassById(SClass sClass);

    //获取所有的班级id
    List<String> listClassId();
}
