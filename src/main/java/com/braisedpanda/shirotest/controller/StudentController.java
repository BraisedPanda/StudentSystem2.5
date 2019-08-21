package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.model.po.Nation;
import com.braisedpanda.shirotest.model.po.SClass;
import com.braisedpanda.shirotest.model.po.Student;
import com.braisedpanda.shirotest.biz.StudentBiz;
import com.braisedpanda.shirotest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    ClassService classService;
    @Autowired
    StudentBiz studentBiz;


    //批量生成学生测试数据
    @RequestMapping("addStudent")
    public void addStudent2(){

         studentBiz.addStudent();



    }


    //查询所有学生
    @RequestMapping("student/all")
    public @ResponseBody
    Map<String,Object> allStudent2(int page, int limit){
        Map<String,Object> map = studentBiz.allStudent(page,limit);

        return map;

    }

    //删除学生信息
    @RequestMapping("student/delete/{stuId}")
    public String delete(@PathVariable("stuId")String stuId){
        studentService.delete(stuId);
        return "user/blank";
    }

    //查询学生的学习成绩卡
    @RequestMapping("student/findcard")
    public void findCard2(){

         studentBiz.findCard();


    }

    //查询学生成绩
    @RequestMapping("student/grades/{stuId}")
    public void findStudentGrades2(@PathVariable("stuId") String stuId){

       studentBiz.findStudentGrades(stuId);


    }

    //编辑学生信息
    @RequestMapping("/editstudent")
    public String editstudent(Student student){
        studentService.updateStudent(student);
        return "student/allstudent";
    }


    //根据stuId查找用户信息，并返回到界面
    @RequestMapping("student/toeditstudent/{stuId}")
    public ModelAndView toeditstudent2(@PathVariable("stuId") String stuId){
        ModelAndView modelAndView = new ModelAndView();

        Student student = studentService.getStudentById(stuId);

        modelAndView.addObject("student",student);

        modelAndView.setViewName("student/editstudent");


        return modelAndView;
    }

    //跳转到添加学生界面
    @RequestMapping("toaddstudent")
    public String tostudent2(Model model){

        List<Nation> nationList = nationService.listNations();

        model.addAttribute("nationlist",nationList);

        List<SClass> classList = classService.listClass();

        model.addAttribute("classlist",classList);

        return "student/addstudent";
    }

    //添加学生信息
    @RequestMapping("student/addstudent")
    public String addstudent2(Student student){

        String str = studentBiz.addstudent(student);

        return str;

    }


}
