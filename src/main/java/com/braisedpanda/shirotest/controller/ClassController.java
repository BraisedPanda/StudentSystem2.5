package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.model.po.SClass;
import com.braisedpanda.shirotest.biz.ClassBiz;
import com.braisedpanda.shirotest.service.ClassService;
import com.braisedpanda.shirotest.service.GradesService;
import com.braisedpanda.shirotest.service.NationService;
import com.braisedpanda.shirotest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ClassController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;

    @Autowired
    ClassBiz classBiz;


    //批量生成学生测试数据
    @ResponseBody
    @RequestMapping("insertClass")
    public void insertClass2(){

       classBiz.insertClass();


    }


    //查询所有班级
    @RequestMapping("class/all")
    public @ResponseBody
    String allClass2(int page, int limit){

       String  result = classBiz.allClass(page,limit);

        return result;

    }

    //跳转界面
    @RequestMapping("toclasslist")
    public String toclasslist(){
        return "class/allclass";
    }


    //根据classid值删除class
    @ResponseBody
    @RequestMapping("class/delete/{classId}")

    public void deleteClassById(@PathVariable("classId") String classId){
        SClass sClass = new SClass();
        sClass.setClassId(classId);
        classService.deleteSClassById(sClass);
    }

    //跳转到编辑班级界面
    @RequestMapping("class/toeditclass/{classId}")
    public ModelAndView toeidtclass2(@PathVariable("classId") String classId){

        ModelAndView modelAndView = new ModelAndView();
        SClass sClass = new SClass();
        sClass.setClassId(classId);
        SClass sclass =  classService.selectSClassById(sClass);

        modelAndView.addObject("class",sclass);

        modelAndView.setViewName("class/editClass");

        return modelAndView;

    }

    //编辑班级信息（提交到数据库）
    @RequestMapping("editclass")
    public String editClass2(SClass sClass, Model model){

        classService.updateSClassById(sClass);

        model.addAttribute("msg","编辑班级信息成功");

        return "menu/msg";
    }


    /*
    跳转到班级详细成绩的页面
     */
    @RequestMapping("class/todetail")
    public String class_todetail(String class_cid,Model model){
        model.addAttribute("class_cid",class_cid);
        return "class/class_student_detail";
    }




    //根据班级的classid查询出该班级所有学生的每次考试成绩，并把数据返回给前端

    @ResponseBody
    @RequestMapping("class/detail/{class_cid}")
    public String classDetail2(@PathVariable("class_cid") String class_cid,int page,int limit,Model model){
        model.addAttribute("class_cid",class_cid);

        String result = classBiz.classDetail(class_cid,page,limit);

        return result;

    }

}
