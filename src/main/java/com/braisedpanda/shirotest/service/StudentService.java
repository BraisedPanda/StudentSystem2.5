package com.braisedpanda.shirotest.service;


import com.braisedpanda.shirotest.model.po.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    //添加学生
    void insertStudent(Student student);

    //得到所有的学生
    List<Student> selectAllStudent();

    //删除学生信息
    void deleteStudentById(Student student);

    //根据id查找学生信息
    Student selectStudentById(Student student);

    //更新学生信息
    void updateStudent(Student student);

    //查询所有班级的Id
    List<String> selectAllClassId();


    int countStudentByCid(String classid);

    //根据班级id值获取所有的学生
    List<Student> getStudentByClassId(String classId);
    //查询所有的学生
    int countStudent();
}
