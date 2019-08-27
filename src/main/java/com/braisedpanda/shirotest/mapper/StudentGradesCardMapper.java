package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.model.po.StudentGradesCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentGradesCardMapper extends tk.mybatis.mapper.common.Mapper<StudentGradesCard>{


    StudentGradesCard getGradesCardById_and_DesCribe(@Param("stuId") String stuId, @Param("testDescribe") String timeDescribe);

}
