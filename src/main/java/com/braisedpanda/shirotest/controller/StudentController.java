package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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


    //批量生成学生测试数据
    @RequestMapping("addStudent")
    public String addStudent(){
        Student student = new Student();
        for(int i=0;i<500;i++){
            Random random = new Random();
            String a =random.nextInt(9)+"";
            String b =random.nextInt(9)+"";
            String c =random.nextInt(9)+"";
            String d =random.nextInt(9)+"";
            String e =random.nextInt(9)+"";
            String f = random.nextInt(56)+"";
            String uid = "2018"+a+"00"+b+c+d+e;

            student.setStuId(uid);
            student.setStuName("user_"+a+i);
            student.setStuPassword("123456");
            student.setStuEmail("user_"+i+"@163.com");
            student.setStuIdCard("340123199"+a+"0"+c+d+e+"5866");
            if(random.nextInt(9)>5){
                student.setStuSex("男");
            }else {
                student.setStuSex("女");
            }

            student.setStuBirthday("199"+a+"-0"+c+"-"+d+e);
//            Nation nation = nationService.getNationById("1");

            student.setNationName("汉族");
            student.setStuStatus("在校");
            student.setStuAge(random.nextInt(9)+16+"");
            student.setClassId("G"+a+"0"+b);
            student.setStuenRollmentTime("2003-1-1");
            student.setStuPolitical("团员");
            student.setStuAddress("安徽省合肥市");
            student.setStuImage("/images/2019-08-02/5705f0d1-4627-4f76-a630-9193866655fb.jpg");
            studentService.addStudent(student);

        }


        return "sd1";

    }


    //查询所有学生
    @RequestMapping("student/all")
    public @ResponseBody
    Map<String,Object> allStudent(int page, int limit){
        int count = studentService.getAllStudent().size();
        PageHelper.startPage(page,limit);
        List<Student> studentList1 = studentService.getAllStudent();
        for (Student stu:
             studentList1) {
            System.out.println(stu);
        }
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList1);

        List<Student> studentList = studentPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",studentList);
        return resultMap;

    }

    //删除学生信息
    @RequestMapping("student/delete/{stuId}")
    public String delete(@PathVariable("stuId")String stuId){
        studentService.delete(stuId);
        return "user/blank";
    }

    //查询学生的学习成绩卡
    @RequestMapping("student/findcard")
    public String findCard(){
        List<Student> studentList = studentService.getAllStudent();
        for (Student s:
             studentList) {
            String stuId = s.getStuId();
            List<StudentGradesCard> cardList = gradesService.getGradesCard(stuId);

        }


        return "user/blank";
    }

    //查询学生成绩
    @RequestMapping("student/grades/{stuId}")
    public String findStudentGrades(@PathVariable("stuId") String stuId){
        List<StudentGradesCard> cardList = gradesService.getGradesCard(stuId);
        for (StudentGradesCard card:
             cardList) {
            StudentGrades grades = gradesService.getGrades(card.getStugradesCardId());
            System.out.println(grades);
        }


        return "user/blank";
    }

    //更新用户信息
    @RequestMapping("/editstudent")
    public String editstudent(Student student){
       studentService.updateStudent(student);
        return "student/allstudent";
    }

    //根据stuId查找用户信息，并返回到界面
    @RequestMapping("student/toeditstudent/{stuId}")
    public ModelAndView toeditstudent(@PathVariable("stuId") String stuId){
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentById(stuId);
        modelAndView.addObject("student",student);
        modelAndView.setViewName("student/editstudent");


        return modelAndView;
    }
    //跳转到添加学生界面
    @RequestMapping("toaddstudent")
    public String tostudent(Model model){

        List<Nation> nationList = nationService.listNations();

        model.addAttribute("nationlist",nationList);
        List<SClass> classList = classService.listClass();
        model.addAttribute("classlist",classList);
        return "student/addstudent";
    }

    //添加学生信息
    @RequestMapping("student/addstudent")
    public String addstudent(Student student){
        //注册学生信息
        String stuId = UUID.randomUUID()+"";
        stuId = stuId.replace("-","");
        student.setStuId(stuId);

        studentService.addStudent(student);

        //注册学生信息时,自动注册用户信息

        User user = new User();
        user.setUsername(student.getStuName());
        user.setPassword(student.getStuPassword());
        user.setEmail(student.getStuEmail());
        user.setBirthday(student.getStuBirthday());
        user.setGender(student.getStuSex());
        user.setImages(student.getStuImage());
        user.setActiveCode(stuId);
        userService.addUser(user);

        //授予该学生权限

        UserRole userRole = new UserRole();
        userRole.setUid(user.getUid());
        userRole.setuRId(stuId);
        userRole.setUsername(student.getStuName());
        userRole.setRoleId("cccdd017ff3b4f9dba8ff77c7836e1f6");
        userRole.setRole("学生");
        userRole.setRoleDescribe("学生可以查看学生、班级信息、我的成绩");
        permissionService.insertUserRole(userRole);


        return "menu/msg";

    }


}
