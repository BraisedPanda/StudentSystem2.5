package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.po.SClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    void insertClass(SClass sclass);

    List<SClass> listClass();

    //根据classid值删除class
    void deleteClassById(String classId);
    //根据classid查找出class
    SClass getClassById(String classId);
    //更新班级信息
    void updateClass(SClass sClass);
    //获取所有的班级id
    List<String> listClassId();
}
