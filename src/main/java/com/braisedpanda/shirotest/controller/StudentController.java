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

            student.setstuId(uid);
            student.setstuName("user_"+a+i);
            student.setstuPassword("123456");
            student.setstuEmail("user_"+i+"@163.com");
            student.setstuIdCard("340123199"+a+"0"+c+d+e+"5866");
            if(random.nextInt(9)>5){
                student.setstuSex("男");
            }else {
                student.setstuSex("女");
            }

            student.setstuBirthday("199"+a+"-0"+c+"-"+d+e);
//            Nation nation = nationService.getNationById("1");

            student.setnationName("汉族");
            student.setstuStatus("在校");
            student.setstuAge(random.nextInt(9)+16+"");
            student.setclassId("G"+a+"0"+b);
            student.setstuenRollmentTime("2003-1-1");
            student.setstuPolitical("团员");
            student.setstuAddress("安徽省合肥市");
            student.setstuImage("/images/2019-08-02/5705f0d1-4627-4f76-a630-9193866655fb.jpg");
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
            String stuId = s.getstuId();
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
            StudentGrades grades = gradesService.getGrades(card.getstugradesCardId());
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

        List<Nation> nationList = nationService.getAllNation();
        model.addAttribute("nationList",nationList);
        List<SClass> classList = classService.getAllClass();
        model.addAttribute("classList",classList);
        return "student/addstudent";
    }

    //添加学生信息
    @RequestMapping("student/addstudent")
    public String addstudent(Student student){
        //注册学生信息
        String stuId = UUID.randomUUID()+"";
        stuId = stuId.replace("-","");
        student.setstuId(stuId);

        studentService.addStudent(student);

        //注册学生信息时,自动注册用户信息

        User user = new User();
        user.setUsername(student.getstuName());
        user.setPassword(student.getstuPassword());
        user.setEmail(student.getstuEmail());
        user.setBirthday(student.getstuBirthday());
        user.setGender(student.getstuSex());
        user.setImages(student.getstuImage());
        user.setactiveCode(stuId);
        userService.addUser(user);

        //授予该学生权限

        UserRole user_role = new UserRole();
        user_role.setUid(user.getUid());
        user_role.setU_r_id(stuId);
        user_role.setUsername(student.getstuName());
        user_role.setroleId("cccdd017ff3b4f9dba8ff77c7836e1f6");
        user_role.setRole("学生");
        user_role.setroleDescribe("学生可以查看学生、班级信息、我的成绩");
        permissionService.addUser_Role(user_role);


        return "menu/msg";

    }


}
