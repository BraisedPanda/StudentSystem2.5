package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.model.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<Student>{

      List<String> selectAllClassId();

      List<Student> selectAllStudent();
}
