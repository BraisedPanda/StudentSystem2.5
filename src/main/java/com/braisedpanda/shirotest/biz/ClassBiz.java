package com.braisedpanda.shirotest.biz;

import com.braisedpanda.shirotest.bean.*;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ClassBiz {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;

    //批量生成学生测试数据

    public List insertClass(){
        SClass sclass = new SClass();
        List<String> classidList = studentService.listClass();
        for (String classid:
             classidList) {
                String[] teacherlist = new String[]{"节振国","赵大华","汤绍箕","黄强辉",
                        "孙德林 ","赵进","张志","孙顺达","孙寿康","吴国梁","张石山","吕文达",
                        "李文","马连良","贾德善","马良","吴克","宗敬先","吕德","钱生禄",};

                int s = teacherlist.length;
                Random random = new Random();
                int a = random.nextInt(s);
                int b = random.nextInt(s);
                int c = random.nextInt(s);
                int d = random.nextInt(s);
                int e = random.nextInt(s);
                int f = random.nextInt(s);
                int g = random.nextInt(s);
                int h = random.nextInt(s);
                int i = random.nextInt(s);
                int j = random.nextInt(s);
                int k = random.nextInt(s);
                int l = random.nextInt(s);
                int m = random.nextInt(s);

                sclass.setClassId(classid);
                sclass.setClassName(classid);
                sclass.setClassTeacher(teacherlist[a]);
                sclass.setChineseTeacher(teacherlist[b]);
                sclass.setMathematicsTeacher(teacherlist[c]);
                sclass.setEnglishTeacher(teacherlist[d]);
                sclass.setPoliticsTeacher(teacherlist[e]);
                sclass.setHistoryTeacher(teacherlist[f]);
                sclass.setGeographyTeacher(teacherlist[g]);
                sclass.setBiologyTeacher(teacherlist[h]);
                sclass.setChemistryTeacher(teacherlist[i]);
                sclass.setPhysicsTeacher(teacherlist[j]);
                sclass.setMusicTeacher(teacherlist[k]);
                sclass.setArtsTeacher(teacherlist[l]);
                sclass.setSportsTeacher(teacherlist[m]);

                int count = studentService.getStudentConutByCid(classid);
                sclass.setClassCount(count);








        }
        return classidList;

    }


    //查询所有班级

    public
    Map<String,Object> allClass(int page, int limit){
        int count = classService.listClass().size();
        PageHelper.startPage(page,limit);
        List<SClass> sClassList1 = classService.listClass();

        PageInfo<SClass> classPageInfo = new PageInfo<>(sClassList1);

        List<SClass> classtList = classPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",classtList);
        return resultMap;

    }

    //跳转到编辑班级界面

    public ModelAndView toeidtclass(@PathVariable("classId") String classId){
        ModelAndView modelAndView = new ModelAndView();
       SClass sclass =  classService.getClassById(classId);
       modelAndView.addObject("class",sclass);
       modelAndView.setViewName("class/editClass");
        return modelAndView;

    }

    //编辑班级信息（提交到数据库）
    public String editClass(SClass sClass,Model model){

        classService.updateClass(sClass);

        model.addAttribute("msg","编辑班级信息成功");
        return "menu/msg";
    }


    /**
     * 根据班级的classid查询出该班级所有学生的每次考试成绩，并把数据返回给前端
     * 通过ajax调用
     * @param class_cid
     * @param page
     * @param limit
     * @return
     */

    public HashMap<String,Object> classDetail(@PathVariable("class_cid") String class_cid,int page,int limit,Model model){


        HashMap<String,Object> resultMap = new HashMap<>();
        //创建学生成绩,来存放改班级所有学生的成绩
        List<StudentGradesCustom> studentGradesCustomList
                = new ArrayList<>();

        model.addAttribute("class_cid",class_cid);

        //根据班级的cid查找出所有的学生信息
        List<Student> studentList = studentService.getStudentByClassId(class_cid);
        for (Student student:
             studentList) {
            StudentGradesCustom studentGradesCustom = new StudentGradesCustom();
            String stuId = student.getStuId();
            //根据每个学生的学生id查找所该学生的学习成绩卡（每次考试对应一张成绩卡）
            List<StudentGradesCard> studentGradesCardList
                    = gradesService.getGradesCard(stuId);
            //根据每张成绩卡，查询对应考试的详细成绩
            for (StudentGradesCard card:
                 studentGradesCardList) {
                String cardid = card.getStugradesCardId();

                StudentGrades studentGrades =  gradesService.getGrades(cardid);

                //设置相关的信息
                studentGradesCustom.setStuName(student.getStuName());
                studentGradesCustom.setStuId(stuId);
                studentGradesCustom.setTestTime(card.getTestTime());
                studentGradesCustom.setTestDescribe(card.getTestDescribe());
                studentGradesCustom.setTotal(studentGrades.getTotal());
                studentGradesCustom.setAverage(studentGrades.getAverage());
                studentGradesCustom.setMaxScore(studentGrades.getMaxScore());
                studentGradesCustom.setMinScore(studentGrades.getMinScore());
                studentGradesCustom.setChinese(studentGrades.getChinese());
                studentGradesCustom.setMathematics(studentGrades.getMathematics());
                studentGradesCustom.setEnglish(studentGrades.getEnglish());
                studentGradesCustom.setPolitics(studentGrades.getPolitics());
                studentGradesCustom.setHistory(studentGrades.getHistory());
                studentGradesCustom.setGeography(studentGrades.getGeography());
                studentGradesCustom.setBiology(studentGrades.getBiology());
                studentGradesCustom.setChemistry(studentGrades.getChemistry());
                studentGradesCustom.setMusic(studentGrades.getMusic());
                studentGradesCustom.setArts(studentGrades.getArts());
                studentGradesCustom.setSports(studentGrades.getSports());


                //存放在数组之中
                studentGradesCustomList.add(studentGradesCustom);



            }



        }
        int count = studentGradesCustomList.size();
        //用Pagehelper分页助手进行分页
        PageHelper.startPage(page,limit);
        PageInfo<StudentGradesCustom> gradesInfo =new PageInfo<>(studentGradesCustomList);

        List<StudentGradesCustom> resultList =  gradesInfo.getList();

        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",resultList);

        return resultMap;


    }



}
