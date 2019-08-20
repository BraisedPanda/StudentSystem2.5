package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.model.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    void addStudent(Student student);

    List<Student> getAllStudent();

    void delete(String stuId);

    Student getStudentById(String stuId);

    void updateStudent(Student student);

    List<String> listClass();

    int getStudentCountByCid(String classid);
    //根据班级的id，查找出该班所有的学生
    List<Student> getStudentByClassId(String classId);
}
