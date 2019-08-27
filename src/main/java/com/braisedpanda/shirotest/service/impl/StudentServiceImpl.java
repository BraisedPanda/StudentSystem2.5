package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.model.po.SClass;
import com.braisedpanda.shirotest.model.po.Student;
import com.braisedpanda.shirotest.mapper.StudentMapper;
import com.braisedpanda.shirotest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    /** 
    * @Description: 添加学生
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void insertStudent(Student student) {

        studentMapper.insert(student);
    }

    /**
    * @Description: 查找所有学生
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<Student> selectAllStudent() {

        List<Student> studentList = studentMapper.selectAll();
        return studentList;
    }

    /**
    * @Description: 根据学生id删除学生
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void deleteStudentById(Student student) {

        studentMapper.deleteByPrimaryKey(student);
    }

    /**
    * @Description: 根据学校id查找学生
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public Student selectStudentById(Student student) {
        Student student2 = studentMapper.selectByPrimaryKey(student);

      return student2;
    }

    /**
    * @Description: 更新学生信息
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateByPrimaryKey(student);

    }
    /**
    * @Description: 查询所有学生的班级
    * @Param:
    * @return: classId值
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<String> selectAllClassId() {
       List<String> classIdlist = studentMapper.selectAllClassId();

        return classIdlist;

    }

    /**
    * @Description: 根据班级id查找学生的总数
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public int countStudentByCid(String classid) {

        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("classId",classid);
        int count = studentMapper.selectCountByExample(example);
       return count;
    }



   

    /** 
    * @Description: 根据班级的classid查找出该班的所有学生
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public List<Student> getStudentByClassId(String classId) {

        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("classId",classId);
        List<Student> list = studentMapper.selectByExample(example);
        return list;
    }
    /**
    * @Description: 查询所有的学生
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */
    @Override
    public int countStudent() {
        Student student = new Student();
        int count = studentMapper.selectCount(student);
        return count;
    }



}
