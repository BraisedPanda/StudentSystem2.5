package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.mapper.ClassGradesCardMapper;
import com.braisedpanda.shirotest.model.po.ClassGradesCard;
import com.braisedpanda.shirotest.service.ClassGradesCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGradesCardServiceImpl implements ClassGradesCardService {
    @Autowired
    ClassGradesCardMapper classGradesCardMapper;


    /** 
    * @Description: 获取所有的班级成绩卡
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public List<ClassGradesCard> listClassGradesCard() {
        List<ClassGradesCard> list = classGradesCardMapper.selectAll();
        return list;
    }

    /** 
    * @Description: 批量生成学生成绩卡
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void insertClassGradesCard(ClassGradesCard cgcrad) {
        classGradesCardMapper.insert(cgcrad);
    }
        
    /**
    * @Description:  根据id查找班级成绩卡
    * @Param:
    * @return:
    * @Date: 2019/8/27 0027
    */


    @Override
    public ClassGradesCard getClassGradesCardByID(String classGradesCardId) {
        ClassGradesCard card = classGradesCardMapper.selectByPrimaryKey(classGradesCardId);
        return card;
    }

}
