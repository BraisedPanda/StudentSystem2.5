package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.bean.Student;
import com.braisedpanda.shirotest.mapper.StudentMapper;
import com.braisedpanda.shirotest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    //新增学生信息
    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    //查找所有学生
    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = studentMapper.getAllStudent();
        return studentList;
    }

    //根据学生id删除学生
    @Override
    public void delete(String stuId) {
        studentMapper.delete(stuId);
    }

    //根据学校id查找学生
    @Override
    public Student getStudentById(String stuId) {
      Student student =  studentMapper.getStudentById(stuId);
      return student;
    }
    //更新学生信息
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }
    //查询所有学生的班级
    @Override
    public List<String> listClass() {
        List<String> classIdlist = studentMapper.listClass();
        return classIdlist;
    }
    //根据班级id查找学生的总数

    @Override
    public int getStudentConutByCid(String classid) {
       int count =  studentMapper.getStudentCountByCid(classid);
       return count;
    }



    //根据班级的classid查找出该班的所有学生


    @Override
    public List<Student> getStudentByClassId(String classId) {
        List<Student> list = studentMapper.getStudentByClassId(classId);
        return list;
    }
}
