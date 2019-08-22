package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.model.po.SClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper extends tk.mybatis.mapper.common.Mapper<SClass>{


    /**
    * @Description: 获取所有班级的id
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    List<String> listClassId();
}
