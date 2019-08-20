package com.braisedpanda.shirotest.controller;


import com.braisedpanda.shirotest.Utils.Utils;
import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.biz.GradesBiz;
import com.braisedpanda.shirotest.service.ClassService;
import com.braisedpanda.shirotest.service.GradesService;
import com.braisedpanda.shirotest.service.NationService;
import com.braisedpanda.shirotest.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class GradesController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;
    @Autowired
    GradesBiz gradesBiz;


    //批量生成学生成绩卡数据
    @RequestMapping("insertGradesCard")
    public String insertGradesCard1(){
        String str = gradesBiz.insertGradesCard();

        return str;

    }

    //批量生成学生成绩
    @RequestMapping("insertGrades")
    public String insertGrades(){
        String str = gradesBiz.insertGrades();

        return str;

    }
    //查询学生成绩
    @ResponseBody
    @RequestMapping("grades/sudent/{stuId}")
    public Map<String,Object> getStudentGrades2(@PathVariable("stuId") String stuId,int page,int limit){
        Map<String,Object> resultMap = gradesBiz.getStudentGrades(stuId,page,limit);

        return resultMap;

    }

    //跳转到我的成绩
    @RequestMapping("tostudentgrades")
    public String tostudentgrades2(Model model,HttpSession session){
        String str = gradesBiz.tostudentgrades(model,session);

        return str;

    }

    //批量生成班级成绩卡
    @ResponseBody
    @RequestMapping("autoinsertClass_gardes_card")
    public void autoinsertClass_gardes_card2(){
        gradesBiz.autoinsertClass_gardes_card();

    }

    //批量生成班级成绩统计
    @ResponseBody
    @RequestMapping("insertClassGrades")
    public HashMap<String,Object> insertClassGrades2(){
        HashMap map =  gradesBiz.insertClassGrades();
        return map;


    }

    //查询班级分数
    @ResponseBody
    @RequestMapping("classgrades")
    public HashMap<String,Object> classgrades2(int page,int limit){
        HashMap<String,Object> map = gradesBiz.classgrades(page,limit);

        return map;

    }



}
