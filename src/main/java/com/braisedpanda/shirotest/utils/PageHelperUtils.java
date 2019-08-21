package com.braisedpanda.shirotest.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageHelperUtils {

    /**
     * 分页工具

     * @param list   传入需要分页的list集合
     * @return       返回分页好的list集合
     */
    public static List getResultList(List list){

        PageInfo pageInfo = new PageInfo(list);
        List resultList = pageInfo.getList();
        return resultList;
    }
}
