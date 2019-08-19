package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Nation;
import com.braisedpanda.shirotest.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NationMapper {

    Nation getNationById(String nationId);

    //查询所有的nation
    List<Nation> getAllNation();
}
