package com.braisedpanda.shirotest.service;


import com.braisedpanda.shirotest.model.po.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    void addStudent(Student student);



    List<Student> getAllStudent();

    void delete(String stuId);


    Student getStudentById(String stuId);


    void updateStudent(Student student);


    List<String> listClass();


    int getStudentConutByCid(String classid);
    //根据班级id值获取所有的学生

    List<Student> getStudentByClassId(String classId);
}
