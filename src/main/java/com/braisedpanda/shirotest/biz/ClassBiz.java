package com.braisedpanda.shirotest.biz;

import com.braisedpanda.shirotest.model.po.SClass;
import com.braisedpanda.shirotest.model.po.Student;
import com.braisedpanda.shirotest.model.po.StudentGrades;
import com.braisedpanda.shirotest.model.po.StudentGradesCard;
import com.braisedpanda.shirotest.model.vo.StudentGradesCustomVO;
import com.braisedpanda.shirotest.service.*;
import com.braisedpanda.shirotest.utils.JsonUtils;
import com.braisedpanda.shirotest.utils.PageHelperUtils;

import com.braisedpanda.shirotest.utils.ResultType;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;


import java.util.*;

@Service
public class ClassBiz {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;
    @Autowired
    StudentGradesService studentGradesService;
    @Autowired
    StudentGradesCardService studentGradesCardService;

    /**
     * 查询所有班级，
     * @param page:当前页数
     * @param limit：每页显示的数据数
     * @return
     */
    public String allClass(int page, int limit){

        try{
            //如果操作成功，向前台返回数据

            int count = classService.countSClass();
            //使用分页助手进行分页
             PageHelper.startPage(page,limit);
            List<SClass> classlist = classService.listSClass();


            List resultList = PageHelperUtils.getResultList(classlist);

            String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();
            System.out.println(resultList);
            return result;
        }catch(Exception e){
            //操作异常，返回错误提示
            String result =   JsonUtils.createResultJson(ResultType.SimpleResultType.ERROR).toJSONString();
            return result;
        }


    }


    /**
     * 根据班级的classid查询出该班级所有学生的每次考试成绩，并把数据返回给前端
     * 通过ajax调用
     *
     * 1、创建学生成绩,来存放改班级所有学生的成绩
     * 2、根据班级的cid查找出所有的学生信息
     * 3、根据每个学生的学生id查找所该学生的学习成绩卡（每次考试对应一张成绩卡）
     * 4、根据每张成绩卡，查询对应考试的详细成绩
     * 5、在StudentGradesCustom中设置学生相关的成绩
     * 6、存放在数组中
     * 7、使用分页把数据传给前端
     *
     */
    public String classDetail(@PathVariable("class_cid") String class_cid,int page,int limit){

        //创建学生成绩,来存放改班级所有学生的成绩
        List<StudentGradesCustomVO> studentGradesCustomVOList
                = new ArrayList<>();



        //根据班级的cid查找出所有的学生信息
        List<Student> studentList = studentService.getStudentByClassId(class_cid);
        for (Student student:
             studentList) {
            StudentGradesCustomVO studentGradesCustomVO = new StudentGradesCustomVO();
            String stuId = student.getStuId();
            //根据每个学生的学生id查找所该学生的学习成绩卡（每次考试对应一张成绩卡）
            List<StudentGradesCard> studentGradesCardList
                    = studentGradesCardService.listStudentGradesCardByStuId(stuId);
            //根据每张成绩卡，查询对应考试的详细成绩
            for (StudentGradesCard card:
                 studentGradesCardList) {
                String cardid = card.getStugradesCardId();

                StudentGrades studentGrades =  studentGradesService.getStudentGradesByCardId(cardid);

                //设置相关的信息
                studentGradesCustomVO.setStuName(student.getStuName());
                studentGradesCustomVO.setStuId(stuId);
                studentGradesCustomVO.setTestTime(card.getTestTime());
                studentGradesCustomVO.setTestDescribe(card.getTestDescribe());
                studentGradesCustomVO.setTotal(studentGrades.getTotal());
                studentGradesCustomVO.setAverage(studentGrades.getAverage());
                studentGradesCustomVO.setMaxScore(studentGrades.getMaxScore());
                studentGradesCustomVO.setMinScore(studentGrades.getMinScore());
                studentGradesCustomVO.setChinese(studentGrades.getChinese());
                studentGradesCustomVO.setMathematics(studentGrades.getMathematics());
                studentGradesCustomVO.setEnglish(studentGrades.getEnglish());
                studentGradesCustomVO.setPolitics(studentGrades.getPolitics());
                studentGradesCustomVO.setHistory(studentGrades.getHistory());
                studentGradesCustomVO.setGeography(studentGrades.getGeography());
                studentGradesCustomVO.setBiology(studentGrades.getBiology());
                studentGradesCustomVO.setChemistry(studentGrades.getChemistry());
                studentGradesCustomVO.setMusic(studentGrades.getMusic());
                studentGradesCustomVO.setArts(studentGrades.getArts());
                studentGradesCustomVO.setSports(studentGrades.getSports());

                //存放在数组之中
                studentGradesCustomVOList.add(studentGradesCustomVO);

            }

        }
        int count = studentGradesCustomVOList.size();


        //用Pagehelper分页助手进行分页
        PageHelper.startPage(page,limit);

        List resultList = PageHelperUtils.getResultList(studentGradesCustomVOList);

        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();

        return result;


    }



    /**
     * 批量生成学生测试数据，插入到数据库中
     * @return
     */
    public void insertClass(){
        SClass sclass = new SClass();
        List<String> classidList = studentService.selectAllClassId();
        /**
         * 1、得到所有的班级id
         * 2、遍历所有的id，并给每个班级赋随机的任课教师
         * 3、把对象存进数据库中
         */
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

            int count = studentService.countStudentByCid(classid);
            sclass.setClassCount(count);

        }


    }



}
