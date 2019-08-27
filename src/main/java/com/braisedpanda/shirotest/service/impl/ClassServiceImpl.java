package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.model.po.SClass;
import com.braisedpanda.shirotest.mapper.ClassMapper;
import com.braisedpanda.shirotest.service.ClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;

   /** 
   * @Description: 插入班级 
   * @Param:  
   * @return: 
   * @Date: 2019/8/22 0022 
   */ 
    @Override
    public void insertClass(SClass sclass) {
        classMapper.insert(sclass);
    }
    
    
   /** 
   * @Description: 查找所有的班级 
   * @Param:  
   * @return: 
   * @Date: 2019/8/22 0022 
   */ 
    @Override
    public List<SClass> listSClass() {
        List<SClass> classList = classMapper.selectAll();
        return classList;
    }


    /** 
    * @Description: 根据班级的classid值删除班级 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void deleteSClassById(SClass sclass) {
        classMapper.deleteByPrimaryKey(sclass);

    }

    /** 
    * @Description: 根据classid查找出对应的class 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public SClass getSClassById(SClass sclass) {
        SClass sClass = classMapper.selectByPrimaryKey(sclass);
        return sClass;
    }

    /** 
    * @Description: 更新班级信息 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public void updateSClassById(SClass sClass) {
         classMapper.updateByPrimaryKey(sClass);
    }


    /** 
    * @Description: 获取所有班级的class
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 
    @Override
    public List<String> listClassId() {
        List<String> list =  classMapper.listClassId();
        return list;

    }
    /**
    * @Description: 统计出所有班级的数目
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */
    @Override
    public int countSClass() {
        SClass c = new SClass();
        int count = classMapper.selectCount(c);
        return count;
    }
}
