package com.braisedpanda.shirotest.controller;


import com.braisedpanda.shirotest.Utils.Utils;
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



    //批量生成学生成绩卡数据
    @RequestMapping("addGradesCard")
    public String addGradesCard(){
        StudentGradesCard card = new StudentGradesCard();
        List<Student> studentList = studentService.getAllStudent();
        for (Student s:
             studentList) {
            String stuId = s.getstuId();
            for(int i=1;i<=3;i++){
                String time = i+"";
                String stugradesCardId = "SGC"+time+stuId;
                card.setstugradesCardId(stugradesCardId);
                card.setstuId(stuId);
                card.settestTime(time);
                if(i==1){
                    card.settestDescribe("开学考试");

                }else if(i==2){
                    card.settestDescribe("期中考试");

                }else {
                    card.settestDescribe("期末考试");
                }
                gradesService.add(card);

            }
        }


        return "user/blank";

    }

    //批量生成学生成绩
    @RequestMapping("addGrades")
    public String addGrades(){
        List<Student> studentList = studentService.getAllStudent();
        for (Student s:
             studentList) {
            String stuId = s.getstuId();
            List<StudentGradesCard> student_grades_cardList = gradesService.getGradesCard(stuId);
            StudentGrades student_grades = new StudentGrades();
            for (StudentGradesCard student_grades_card:
                    student_grades_cardList ) {
                String stugradesCardId = student_grades_card.getstugradesCardId();

                student_grades.setstugradesId("SGI"+stugradesCardId);
                student_grades.setstugradesCardId(stugradesCardId);
                Random random = new Random();
                double a = 60+random.nextInt(90);
                double b = 60+random.nextInt(90);
                double c = 60+random.nextInt(90);
                double d = 60+random.nextInt(90);
                double e = 60+random.nextInt(90);
                double f = 60+random.nextInt(90);
                double g = 60+random.nextInt(90);
                double h = 60+random.nextInt(90);
                double i = 60+random.nextInt(90);
                double j = 60+random.nextInt(90);
                double k = 60+ random.nextInt(90);
                double l = 60+random.nextInt(90);
                student_grades.setChinese(a);
                student_grades.setMathematics(b);
                student_grades.setEnglish(c);
                student_grades.setPolitics(d);
                student_grades.setHistory(e);
                student_grades.setGeography(f);
                student_grades.setBiology(g);
                student_grades.setChemistry(h);
                student_grades.setPhysics(i);
                student_grades.setMusic(j);
                student_grades.setArts(k);
                student_grades.setSports(l);

                double[] array = new double[]{a,b,c,d,e,f,g,h,i,j,k,l};
                double max=array[0];
                double min=array[0];
                double total=0;
                for(int x=0;x<array.length;x++){

                    if(max<array[x]){
                        max=array[x];
                    }
                    if(min>array[x]){
                        min=array[x];
                    }
                    total = total+array[x];
                }
                double ave = total/array.length;

                student_grades.setmaxScore(max);
                student_grades.setminScore(min);
                student_grades.setTotal(total);
                student_grades.setAverage(ave);

                System.out.println(student_grades);
                gradesService.addGrades(student_grades);

            }



        }

        return "user/blank";

    }
    //查询学生成绩
    @ResponseBody
    @RequestMapping("grades/sudent/{stuId}")
    public Map<String,Object> getStudentGrades(@PathVariable("stuId") String stuId,int page,int limit){
        List<StudentGradesCustom> sgcList = new ArrayList<StudentGradesCustom>();

        //根据学生id查找学生
        Student student = studentService.getStudentById(stuId);

        //成绩卡，根据学生的id在成绩卡中，查询多次考试的成绩单号
        StudentGradesCard gcard = new StudentGradesCard();
        List<StudentGradesCard> gcardList =  gradesService.getGradesCard(stuId);
        for (StudentGradesCard card:
                gcardList) {
            //创建前端展示的成绩单
            StudentGradesCustom sgc = new StudentGradesCustom();

            String cardid = card.getstugradesCardId();
            //多次成绩单号已经查到
           StudentGrades grades = gradesService.getGrades(cardid);

            //设置学生id
            sgc.setstuId(stuId);
            //设置学生姓名
            sgc.setstuName(student.getstuName());
            //设置学生班级
            sgc.setclassId(student.getclassId());
            //设置测试的描述信息
            sgc.settestDescribe(card.gettestDescribe());
            //设置总分
            sgc.setTotal(grades.getTotal());
            //设置平均分
            sgc.setAverage(grades.getAverage());
            //设置最高分
            sgc.setmaxScore(grades.getmaxScore());
            //设置最低分
            sgc.setminScore(grades.getminScore());
            //设置语文分数
            sgc.setChinese(grades.getChinese());
            //设置数学分数
            sgc.setMathematics(grades.getMathematics());
            //设置英语分数
            sgc.setEnglish(grades.getEnglish());
            //设置政治分数
            sgc.setPolitics(grades.getPolitics());
            //设置历史分数
            sgc.setHistory(grades.getHistory());
            //设置地理分数
            sgc.setGeography(grades.getGeography());
            //设置生物分数
            sgc.setBiology(grades.getBiology());
            //设置化学分数
            sgc.setChemistry(grades.getChemistry());
            //设置物理分数
            sgc.setPhysics(grades.getPhysics());
            //设置音乐分数
            sgc.setMusic(grades.getMusic());
            //设置美术分数
            sgc.setArts(grades.getArts());
            //设置体育分数
            sgc.setSports(grades.getSports());
            //设置考试的时间
            sgc.settestTime(card.gettestTime());

            sgcList.add(sgc);
        }



        int count = sgcList.size();
        PageHelper.startPage(page,limit);
   ;

        PageInfo<StudentGradesCustom> studentGradesPageInfo = new PageInfo<>(sgcList);

        List<StudentGradesCustom> studentGradesList = studentGradesPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",studentGradesList);
        return resultMap;




    }
    //跳转到我的成绩
    @RequestMapping("tostudentgrades")
    public String tostudentgrades(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        String stuId = user.getactiveCode();
        System.out.println(user);
        model.addAttribute("stuId",stuId);

        return "student/studentgrades";

    }

    //批量生成班级成绩卡
    @ResponseBody
    @RequestMapping("autoaddclass_gardes_card")
    public void autoaddclass_gardes_card(){
        //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
       List<StudentGradesCard> sg_cardlist = gradesService.getSGCard();
       //获取所有的班级id
       List<String> classidlist = classService.getAllClassId();
        for (String s:
             classidlist) {
           //批量生成student_gardes_card信息
            for (StudentGradesCard sgc:
                 sg_cardlist) {
                ClassGradesCard cgcrad = new ClassGradesCard();
                //设置唯一id值，CGC+班级id+考试时间
                String classGradesCardId = "CGC"+s+sgc.gettestTime().replace("-","");
                cgcrad.setclassGradesCardId(classGradesCardId);
                //设置classId
                cgcrad.setclassId(s);
                cgcrad.settestTime(sgc.gettestTime());
                cgcrad.settestDescribe(sgc.gettestDescribe());


               gradesService.addClassGradesCard(cgcrad);
            }

        }

    }

    //批量生成班级成绩统计
    @ResponseBody
    @RequestMapping("addClassGrades")
    public HashMap<String,Object> addClassGrades(){
        HashMap<String,Object> resultMap = new HashMap<>();

        //获取各个班的所有学生
        ClassGrades ClassGrades = new ClassGrades();
        //获取所有的班级成绩卡片
        List<ClassGradesCard> ClassGradesCardList = gradesService.getAllClassGradesCard();

        for (ClassGradesCard ClassGradesCard:
                ClassGradesCardList  ) {

            String classGradesId = "CGI"+ ClassGradesCard.getclassGradesCardId();
            ClassGrades.setclassGradesId(classGradesId);
            ClassGrades.setclassGradesCardId(ClassGradesCard.getclassGradesCardId());

            //获取classId
            String classId = ClassGradesCard.getclassId();
            System.out.println("班级ID："+classId+"==============================");

                //根据classId查找出该班级所有的学生
                List<Student> studentList = studentService.getStudentByClassId(classId);

                            List<Double> totallist = new ArrayList<>();
                            List<Double> chineselist = new ArrayList<>();
                            List<Double> mathematicslist = new ArrayList<>();
                            List<Double> englishlist = new ArrayList<>();
                            List<Double> politicslist = new ArrayList<>();
                            List<Double> historylist = new ArrayList<>();
                            List<Double> geographylist = new ArrayList<>();
                            List<Double> biologylist = new ArrayList<>();
                            List<Double> chemistrylist = new ArrayList<>();
                            List<Double> physicslist = new ArrayList<>();
                            List<Double> musiclist = new ArrayList<>();
                            List<Double> artslist = new ArrayList<>();
                            List<Double> sportslist = new ArrayList<>();

                            System.out.println("该班级所有学生：==============================");

                            for (Student stu:
                                    studentList) {
                                System.out.println("学生姓名："+stu.getstuName());

                                //根据每个学生的学生stuId，查找出该学生的成绩卡
                                String stuId = stu.getstuId();
                                String time_describe = ClassGradesCard.gettestDescribe();

                                StudentGradesCard student_Grades_Card = gradesService.getGradesCardById_and_DesCribe(stuId,time_describe);

                                String stugradesCardId = student_Grades_Card.getstugradesCardId();

                                StudentGrades student_grades =  gradesService.getGrades(stugradesCardId);

                                double total = student_grades.getTotal();
                                double chinese = student_grades.getChinese();
                                double mathematics = student_grades.getMathematics();
                                double english = student_grades.getEnglish();
                                double politics = student_grades.getPolitics();
                                double history = student_grades.getHistory();
                                double geography = student_grades.getGeography();
                                double biology = student_grades.getBiology();
                                double chemistry = student_grades.getChemistry();
                                double physics = student_grades.getPhysics();
                                double music = student_grades.getMusic();
                                double arts = student_grades.getArts();
                                double sports = student_grades.getSports();

                                totallist.add(total);
                                chineselist.add(chinese);
                                mathematicslist.add(mathematics);
                                englishlist.add(english);
                                politicslist.add(politics);
                                historylist.add(history);
                                geographylist.add(geography);
                                biologylist.add(biology);
                                chemistrylist.add(chemistry);
                                physicslist.add(physics);
                                musiclist.add(music);
                                artslist.add(arts);
                                sportslist.add(sports);

                            }
                            Utils utils = new Utils();
                            //总分各分值统计
                            Double totalMax = utils.getMax(totallist);
                            Double totalMin = utils.getMin(totallist);
                            Double totalAver = utils.getAver(totallist);

                            ClassGrades.settotalAve(totalAver);
                            ClassGrades.settotalMax(totalMax);
                            ClassGrades.settotalMin(totalMin);

                            //语文各分值统计
                            Double chineseMax = utils.getMax(chineselist);
                            Double chineseMin = utils.getMin(chineselist);
                            Double chineseAver = utils.getAver(chineselist);

                            ClassGrades.setchineseAve(chineseAver);
                            ClassGrades.setchineseMax(chineseMax);
                            ClassGrades.setchineseMin(chineseMin);

                            //数学各分值统计
                            Double mathematicsMax = utils.getMax(mathematicslist);
                            Double mathematicsMin = utils.getMin(mathematicslist);
                            Double mathematicsAver = utils.getAver(mathematicslist);

                            ClassGrades.setmathematicsAve(mathematicsAver);
                            ClassGrades.setmathematicsMax(mathematicsMax);
                            ClassGrades.setmathematicsMin(mathematicsMin);

                            //英语各分值统计
                            Double englishMax = utils.getMax(englishlist);
                            Double englishMin = utils.getMin(englishlist);
                            Double englishAver = utils.getAver(englishlist);

                            ClassGrades.setenglishAve(englishAver);
                            ClassGrades.setenglishMax(englishMax);
                            ClassGrades.setenglishMin(englishMin);

                            //政治各分值统计
                            Double politicsMax = utils.getMax(politicslist);
                            Double politicsMin = utils.getMin(politicslist);
                            Double politicsAver = utils.getAver(politicslist);

                            ClassGrades.setpoliticsAve(politicsAver);
                            ClassGrades.setpoliticsMax(politicsMax);
                            ClassGrades.setpoliticsMin(politicsMin);


                            //历史各分值统计
                            Double historyMax = utils.getMax(historylist);
                            Double historyMin = utils.getMin(historylist);
                            Double historyAver = utils.getAver(historylist);

                            ClassGrades.sethistoryMax(historyMax);
                            ClassGrades.sethistoryMin(historyMin);
                            ClassGrades.sethistoryAve(historyAver);

                            //地理各分值统计
                            Double geographyMax = utils.getMax(geographylist);
                            Double geographyMin = utils.getMin(geographylist);
                            Double geographyAver = utils.getAver(geographylist);

                            ClassGrades.setgeographyAve(geographyAver);
                            ClassGrades.setgeographyMax(geographyMax);
                            ClassGrades.setgeographyMin(geographyMin);


                            //生物各分值统计
                            Double biologyMax = utils.getMax(biologylist);
                            Double biologyMin = utils.getMin(biologylist);
                            Double biologyAver = utils.getAver(biologylist);

                            ClassGrades.setbiologyAve(biologyAver);
                            ClassGrades.setbiologyMax(biologyMax);
                            ClassGrades.setbiologyMin(biologyMin);



                            //化学各分值统计
                            Double chemistryMax = utils.getMax(chemistrylist);
                            Double chemistryMin = utils.getMin(chemistrylist);
                            Double chemistryAver = utils.getAver(chemistrylist);

                            ClassGrades.setchemistryAve(chemistryAver);
                            ClassGrades.setchineseMin(chemistryMin);
                            ClassGrades.setchemistryMax(chemistryMax);


                            //物理各分值统计
                            Double physicsMax = utils.getMax(physicslist);
                            Double physicsMin = utils.getMin(physicslist);
                            Double physicsAver = utils.getAver(physicslist);

                            ClassGrades.setphysicsAve(physicsAver);
                            ClassGrades.setphysicsMax(physicsMax);
                            ClassGrades.setphysicsMin(physicsMin);

                            //音乐各分值统计
                            Double musicMax = utils.getMax(musiclist);
                            Double musicMin = utils.getMin(musiclist);
                            Double musicAver = utils.getAver(musiclist);

                            ClassGrades.setmusicAve(musicAver);
                            ClassGrades.setmusicMax(musicMax);
                            ClassGrades.setmusicMin(musicMin);


                            //美术各分值统计
                            Double artsMax = utils.getMax(artslist);
                            Double artsMin = utils.getMin(artslist);
                            Double artsAver = utils.getAver(artslist);

                            ClassGrades.setartsMax(artsMax);
                            ClassGrades.setartsAve(artsAver);
                            ClassGrades.setartsMin(artsMin);

                            //体育各分值统计
                            Double sportsMax = utils.getMax(sportslist);
                            Double sportsMin = utils.getMin(sportslist);
                            Double sportsAver = utils.getAver(sportslist);

                            ClassGrades.setsportsMin(sportsMin);
                            ClassGrades.setsportsAve(sportsAver);
                            ClassGrades.setsportsMax(sportsMax);

                            System.out.println("该班级成绩分数："+ClassGrades);

                            gradesService.addClassGrades(ClassGrades);

                 }




        return null;

    }


    @ResponseBody
    @RequestMapping("classgrades")
    public HashMap<String,Object> classgrades(int page,int limit){
        HashMap<String,Object> resultMap = new HashMap<>();



        int count = gradesService.getAllClassGrades().size();
        PageHelper.startPage(page,limit);
        List<ClassGrades> ClassGradeslist1 = gradesService.getAllClassGrades();

        PageInfo<ClassGrades> ClassGradesPageInfo = new PageInfo<>(ClassGradeslist1);

        List<ClassGrades> ClassGradeslist2 = ClassGradesPageInfo.getList();

        List<Object> customList = new ArrayList<>();

        for (ClassGrades cgrades:
                ClassGradeslist2 ) {
            String classGradesCardId = cgrades.getclassGradesCardId();
            ClassGradesCard card = gradesService.getClassGradesCardByID(classGradesCardId);
            CustomClassGrades custom = new CustomClassGrades();
            custom.setclassId(card.getclassId());
            custom.settestDescribe(card.gettestDescribe());
            custom.settestTime(card.gettestTime());
            custom.settotalAve(cgrades.gettotalAve());
            custom.settotalMax(cgrades.gettotalMax());
            custom.settotalMin(cgrades.gettotalMin());
            custom.setchineseMax(cgrades.getchineseMax());
            custom.setchineseMin(cgrades.getchineseMin());
            custom.setchineseAve(cgrades.getchineseAve());
            custom.setmathematicsMax(cgrades.getmathematicsMax());
            custom.setmathematicsMin(cgrades.getmathematicsMin());
            custom.setmathematicsAve(cgrades.getmathematicsAve());
            custom.setenglishMax(cgrades.getenglishMax());
            custom.setenglishMin(cgrades.getenglishMin());
            custom.setenglishAve(cgrades.getenglishAve());
            custom.setpoliticsMax(cgrades.getpoliticsMax());
            custom.setpoliticsMin(cgrades.getpoliticsMin());
            custom.setpoliticsAve(cgrades.getpoliticsAve());
            custom.sethistoryMax(cgrades.gethistoryMax());
            custom.sethistoryMin(cgrades.gethistoryMin());
            custom.sethistoryAve(cgrades.gethistoryAve());
            custom.setgeographyMax(cgrades.getgeographyMax());
            custom.setgeographyMin(cgrades.getgeographyMin());
            custom.setgeographyAve(cgrades.getgeographyAve());
            custom.setbiologyAve(cgrades.getbiologyAve());
            custom.setbiologyMax(cgrades.getbiologyMax());
            custom.setbiologyMin(cgrades.getbiologyMin());
            custom.setchemistryAve(cgrades.getchemistryAve());
            custom.setchemistryMax(cgrades.getchemistryMax());
            custom.setchemistryMin(cgrades.getchemistryMin());
            custom.setphysicsMax(cgrades.getphysicsMax());
            custom.setphysicsMin(cgrades.getphysicsMin());
            custom.setphysicsAve(cgrades.getphysicsAve());
            custom.setmusicAve(cgrades.getmusicAve());
            custom.setmusicMin(cgrades.getmusicMin());
            custom.setmusicMax(cgrades.getmusicMax());
            custom.setartsMax(cgrades.getartsMax());
            custom.setartsMin(cgrades.getartsMin());
            custom.setartsAve(cgrades.getartsAve());
            custom.setsportsMax(cgrades.getsportsMax());
            custom.setsportsMin(cgrades.getsportsMin());
            custom.setsportsAve(cgrades.getsportsAve());






            customList.add(custom);

        }



        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",customList);
        return resultMap;





    }










}
