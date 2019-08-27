package com.braisedpanda.shirotest.biz;


import com.braisedpanda.shirotest.service.*;
import com.braisedpanda.shirotest.utils.JsonUtils;

import com.braisedpanda.shirotest.utils.ResultType;
import com.braisedpanda.shirotest.utils.Utils;
import com.braisedpanda.shirotest.model.po.*;
import com.braisedpanda.shirotest.model.vo.CustomClassGradesVO;
import com.braisedpanda.shirotest.model.vo.StudentGradesCustomVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class GradesBiz {
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
    @Autowired
    ClassGradesCardService classGradesCardService;
    @Autowired
    ClassGradesService classGradesService;

    /**
     * 批量生成学生成绩卡数据
     * 1、得到所有的学生
     * 2、根据每个学生的id值，创建学生的成绩卡
     * 3、把成绩卡存入到数据库中
     * @return
     */
    public void insertGradesCard(){
        StudentGradesCard card = new StudentGradesCard();
        List<Student> studentList = studentService.selectAllStudent();
        for (Student s:
             studentList) {
            String stuId = s.getStuId();
            for(int i=1;i<=3;i++){
                String time = i+"";
                String stugradesCardId = "SGC"+time+stuId;
                card.setStugradesCardId(stugradesCardId);
                card.setStuId(stuId);
                card.setTestTime(time);
                if(i==1){
                    card.setTestDescribe("开学考试");

                }else if(i==2){
                    card.setTestDescribe("期中考试");

                }else {
                    card.setTestDescribe("期末考试");
                }
                studentGradesCardService.insertStudentGradesCard(card);

            }
        }

    }

    /**
     * 批量生成学生测试成绩
     * 1、查询到所有的学生
     * 2、根据每个学生的id查找出所有学生的成绩卡
     * 3、根据查出的学生成绩卡id值，插入考试成绩
     * 4、考试成绩存入到数据库中
     * @return
     */
    public void insertGrades(){
        List<Student> studentList = studentService.selectAllStudent();
        for (Student s:
             studentList) {
            String stuId = s.getStuId();
            List<StudentGradesCard> studentGradesCardList = studentGradesCardService.listStudentGradesCardByStuId(stuId);
            StudentGrades studentGrades = new StudentGrades();
            for (StudentGradesCard studentGradesCard:
                    studentGradesCardList ) {
                String stugradesCardId = studentGradesCard.getStugradesCardId();

                studentGrades.setStugradesId("SGI"+stugradesCardId);
                studentGrades.setStugradesCardId(stugradesCardId);
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
                studentGrades.setChinese(a);
                studentGrades.setMathematics(b);
                studentGrades.setEnglish(c);
                studentGrades.setPolitics(d);
                studentGrades.setHistory(e);
                studentGrades.setGeography(f);
                studentGrades.setBiology(g);
                studentGrades.setChemistry(h);
                studentGrades.setPhysics(i);
                studentGrades.setMusic(j);
                studentGrades.setArts(k);
                studentGrades.setSports(l);

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

                studentGrades.setMaxScore(max);
                studentGrades.setMinScore(min);
                studentGrades.setTotal(total);
                studentGrades.setAverage(ave);


                studentGradesService.insertStudentGrades(studentGrades);

            }



        }

    }


    /**
     * 根据学生的id查询学生成绩
     * @param stuId
     * @param page
     * @param limit
     *
     * 1、根据学生的ID值查找出该学生的学生成绩卡
     * 2、根据成绩卡，查找出每次考试的详细成绩
     * 3、把成绩封装到对象中，传给前端
     */
    public String getStudentGrades(@PathVariable("stuId") String stuId,int page,int limit){
        List<StudentGradesCustomVO> sgcList = new ArrayList<StudentGradesCustomVO>();

        //根据学生id查找学生
        Student stu = new Student();
        stu.setStuId(stuId);
        Student student = studentService.selectStudentById(stu);

        //成绩卡，根据学生的id在成绩卡中，查询多次考试的成绩单号
        StudentGradesCard gcard = new StudentGradesCard();
        List<StudentGradesCard> gcardList =  studentGradesCardService.listStudentGradesCardByStuId(stuId);
        for (StudentGradesCard card:
                gcardList) {

            //创建前端展示的成绩单
            StudentGradesCustomVO sgc = new StudentGradesCustomVO();

            String cardid = card.getStugradesCardId();
            //多次成绩单号已经查到
           StudentGrades grades = studentGradesService.getStudentGradesByCardId(cardid);

            //设置学生id
            sgc.setStuId(stuId);
            //设置学生姓名
            sgc.setStuName(student.getStuName());
            //设置学生班级
            sgc.setClassId(student.getClassId());
            //设置测试的描述信息
            sgc.setTestDescribe(card.getTestDescribe());
            //设置总分
            sgc.setTotal(grades.getTotal());
            //设置平均分
            sgc.setAverage(grades.getAverage());
            //设置最高分
            sgc.setMaxScore(grades.getMaxScore());
            //设置最低分
            sgc.setMinScore(grades.getMinScore());
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
            sgc.setTestTime(card.getTestTime());

            sgcList.add(sgc);
        }

        //使用分页传给前端

        int count = sgcList.size();

        PageHelper.startPage(page,limit);
        PageInfo pageInfo = new PageInfo(sgcList);
        List resultList = pageInfo.getList();


        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();

        return result;




    }


    /**
     * 批量生成班级成绩卡的测试数据
     * 1、查询出所有的班级，准备为每个班级生成班级成绩卡
     * 2、根据学生成绩卡的信息，统计出总共有几次考试，并把相关的考试记录同步到班级成绩卡中
     * 3、插入数据到数据库中
     */
    public void autoinsertClass_gardes_card(){
        //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
       List<StudentGradesCard> sg_cardlist = gradesService.getSGCard();
       //获取所有的班级id
       List<String> classidlist = classService.listClassId();
        for (String s:
             classidlist) {
           //批量生成student_gardes_card信息
            for (StudentGradesCard sgc:
                 sg_cardlist) {
                ClassGradesCard cgcrad = new ClassGradesCard();
                //设置唯一id值，CGC+班级id+考试时间
                String classGradesCardId = "CGC"+s+sgc.getTestTime().replace("-","");
                cgcrad.setClassGradesCardId(classGradesCardId);
                //设置classId
                cgcrad.setClassId(s);
                cgcrad.setTestTime(sgc.getTestTime());
                cgcrad.setTestDescribe(sgc.getTestDescribe());


                classGradesCardService.insertClassGradesCard(cgcrad);
            }

        }

    }

    /**
     * 批量生成班级成绩统计测试数据
     * 1、获取各个班的所有学生，并所有所有的班级成绩卡
     * 2、遍历每个班级，查找出该班级的所有学生，把学生的成绩统计出来
     * 3、把班级成绩存入到数据库中
     * @return
     */
    public void insertClassGrades(){


        //获取各个班的所有学生
        ClassGrades ClassGrades = new ClassGrades();
        //获取所有的班级成绩卡片
        List<ClassGradesCard> ClassGradesCardList = classGradesCardService.listClassGradesCard();

        for (ClassGradesCard ClassGradesCard:
                ClassGradesCardList  ) {

            String classGradesId = "CGI"+ ClassGradesCard.getClassGradesCardId();
            ClassGrades.setClassGradesId(classGradesId);
            ClassGrades.setClassGradesCardId(ClassGradesCard.getClassGradesCardId());

            //获取classId
            String classId = ClassGradesCard.getClassId();


                //根据classId查找出该班级所有的学生
                List<Student> studentList = studentService.getStudentByClassId(classId);

                            List<Double> totallist = new ArrayList<>();
                            List<Double> chineselist = new ArrayList<>();
                            List<Double> mathematicslist = new ArrayList<>();
                            List<Double> Englishlist = new ArrayList<>();
                            List<Double> Politicslist = new ArrayList<>();
                            List<Double> Historylist = new ArrayList<>();
                            List<Double> Geographylist = new ArrayList<>();
                            List<Double> Biologylist = new ArrayList<>();
                            List<Double> Chemistrylist = new ArrayList<>();
                            List<Double> Physicslist = new ArrayList<>();
                            List<Double> musiclist = new ArrayList<>();
                            List<Double> artslist = new ArrayList<>();
                            List<Double> sportslist = new ArrayList<>();



                            for (Student stu:
                                    studentList) {


                                //根据每个学生的学生stuId，查找出该学生的成绩卡
                                String stuId = stu.getStuId();
                                String timeDescribe = ClassGradesCard.getTestDescribe();

                                StudentGradesCard studentGradesCard = studentGradesCardService.getGradesCardById_and_DesCribe(stuId,timeDescribe);

                                String stugradesCardId = studentGradesCard.getStugradesCardId();

                                StudentGrades studentGrades =  studentGradesService.getStudentGradesByCardId(stugradesCardId);

                                double total = studentGrades.getTotal();
                                double chinese = studentGrades.getChinese();
                                double mathematics = studentGrades.getMathematics();
                                double English = studentGrades.getEnglish();
                                double Politics = studentGrades.getPolitics();
                                double History = studentGrades.getHistory();
                                double Geography = studentGrades.getGeography();
                                double Biology = studentGrades.getBiology();
                                double Chemistry = studentGrades.getChemistry();
                                double Physics = studentGrades.getPhysics();
                                double music = studentGrades.getMusic();
                                double arts = studentGrades.getArts();
                                double sports = studentGrades.getSports();

                                totallist.add(total);
                                chineselist.add(chinese);
                                mathematicslist.add(mathematics);
                                Englishlist.add(English);
                                Politicslist.add(Politics);
                                Historylist.add(History);
                                Geographylist.add(Geography);
                                Biologylist.add(Biology);
                                Chemistrylist.add(Chemistry);
                                Physicslist.add(Physics);
                                musiclist.add(music);
                                artslist.add(arts);
                                sportslist.add(sports);

                            }
                            Utils utils = new Utils();
                            //总分各分值统计
                            Double totalMax = utils.getMax(totallist);
                            Double totalMin = utils.getMin(totallist);
                            Double totalAver = utils.getAver(totallist);

                            ClassGrades.setTotalAve(totalAver);
                            ClassGrades.setTotalMax(totalMax);
                            ClassGrades.setTotalMin(totalMin);

                            //语文各分值统计
                            Double chineseMax = utils.getMax(chineselist);
                            Double chineseMin = utils.getMin(chineselist);
                            Double chineseAver = utils.getAver(chineselist);

                            ClassGrades.setChineseAve(chineseAver);
                            ClassGrades.setChineseMax(chineseMax);
                            ClassGrades.setChineseMin(chineseMin);

                            //数学各分值统计
                            Double mathematicsMax = utils.getMax(mathematicslist);
                            Double mathematicsMin = utils.getMin(mathematicslist);
                            Double mathematicsAver = utils.getAver(mathematicslist);

                            ClassGrades.setMathematicsAve(mathematicsAver);
                            ClassGrades.setMathematicsMax(mathematicsMax);
                            ClassGrades.setMathematicsMin(mathematicsMin);

                            //英语各分值统计
                            Double EnglishMax = utils.getMax(Englishlist);
                            Double EnglishMin = utils.getMin(Englishlist);
                            Double EnglishAver = utils.getAver(Englishlist);

                            ClassGrades.setEnglishAve(EnglishAver);
                            ClassGrades.setEnglishMax(EnglishMax);
                            ClassGrades.setEnglishMin(EnglishMin);

                            //政治各分值统计
                            Double PoliticsMax = utils.getMax(Politicslist);
                            Double PoliticsMin = utils.getMin(Politicslist);
                            Double PoliticsAver = utils.getAver(Politicslist);

                            ClassGrades.setPoliticsAve(PoliticsAver);
                            ClassGrades.setPoliticsMax(PoliticsMax);
                            ClassGrades.setPoliticsMin(PoliticsMin);


                            //历史各分值统计
                            Double HistoryMax = utils.getMax(Historylist);
                            Double HistoryMin = utils.getMin(Historylist);
                            Double HistoryAver = utils.getAver(Historylist);

                            ClassGrades.setHistoryMax(HistoryMax);
                            ClassGrades.setHistoryMin(HistoryMin);
                            ClassGrades.setHistoryAve(HistoryAver);

                            //地理各分值统计
                            Double GeographyMax = utils.getMax(Geographylist);
                            Double GeographyMin = utils.getMin(Geographylist);
                            Double GeographyAver = utils.getAver(Geographylist);

                            ClassGrades.setGeographyAve(GeographyAver);
                            ClassGrades.setGeographyMax(GeographyMax);
                            ClassGrades.setGeographyMin(GeographyMin);


                            //生物各分值统计
                            Double BiologyMax = utils.getMax(Biologylist);
                            Double BiologyMin = utils.getMin(Biologylist);
                            Double BiologyAver = utils.getAver(Biologylist);

                            ClassGrades.setBiologyAve(BiologyAver);
                            ClassGrades.setBiologyMax(BiologyMax);
                            ClassGrades.setBiologyMin(BiologyMin);



                            //化学各分值统计
                            Double ChemistryMax = utils.getMax(Chemistrylist);
                            Double ChemistryMin = utils.getMin(Chemistrylist);
                            Double ChemistryAver = utils.getAver(Chemistrylist);

                            ClassGrades.setChemistryAve(ChemistryAver);
                            ClassGrades.setChineseMin(ChemistryMin);
                            ClassGrades.setChemistryMax(ChemistryMax);


                            //物理各分值统计
                            Double PhysicsMax = utils.getMax(Physicslist);
                            Double PhysicsMin = utils.getMin(Physicslist);
                            Double PhysicsAver = utils.getAver(Physicslist);

                            ClassGrades.setPhysicsAve(PhysicsAver);
                            ClassGrades.setPhysicsMax(PhysicsMax);
                            ClassGrades.setPhysicsMin(PhysicsMin);

                            //音乐各分值统计
                            Double musicMax = utils.getMax(musiclist);
                            Double musicMin = utils.getMin(musiclist);
                            Double musicAver = utils.getAver(musiclist);

                            ClassGrades.setMusicAve(musicAver);
                            ClassGrades.setMusicMax(musicMax);
                            ClassGrades.setMusicMin(musicMin);


                            //美术各分值统计
                            Double artsMax = utils.getMax(artslist);
                            Double artsMin = utils.getMin(artslist);
                            Double artsAver = utils.getAver(artslist);

                            ClassGrades.setArtsMax(artsMax);
                            ClassGrades.setArtsAve(artsAver);
                            ClassGrades.setArtsMin(artsMin);

                            //体育各分值统计
                            Double sportsMax = utils.getMax(sportslist);
                            Double sportsMin = utils.getMin(sportslist);
                            Double sportsAver = utils.getAver(sportslist);

                            ClassGrades.setSportsMin(sportsMin);
                            ClassGrades.setSportsAve(sportsAver);
                            ClassGrades.setSportsMax(sportsMax);



                            classGradesService.insertClassGrades(ClassGrades);

                 }

    }


    /**
     * 查找出所有班级的成绩
     * 1、查出所有班级的成绩
     * 2、封装成绩数据到customGrades中
     * 3、使用分页把前端数据传给前端
     * @param page
     * @param limit
     * @return
     */
    public String classgrades(int page,int limit){


        int count = classGradesService.countClassGrades();

        PageHelper.startPage(page,limit);

        List<ClassGrades> ClassGradeslist1 = classGradesService.listClassGrades();

        List<Object> customList = new ArrayList<>();

        for (ClassGrades cgrades:
                ClassGradeslist1 ) {
            String classGradesCardId = cgrades.getClassGradesCardId();
            ClassGradesCard card = classGradesCardService.getClassGradesCardByID(classGradesCardId);
            CustomClassGradesVO custom = new CustomClassGradesVO();
            custom.setClassId(card.getClassId());
            custom.setTestDescribe(card.getTestDescribe());
            custom.setTestTime(card.getTestTime());
            custom.setTotalAve(cgrades.getTotalAve());
            custom.setTotalMax(cgrades.getTotalMax());
            custom.setTotalMin(cgrades.getTotalMin());
            custom.setChineseMax(cgrades.getChineseMax());
            custom.setChineseMin(cgrades.getChineseMin());
            custom.setChineseAve(cgrades.getChineseAve());
            custom.setMathematicsMax(cgrades.getMathematicsMax());
            custom.setMathematicsMin(cgrades.getMathematicsMin());
            custom.setMathematicsAve(cgrades.getMathematicsAve());
            custom.setEnglishMax(cgrades.getEnglishMax());
            custom.setEnglishMin(cgrades.getEnglishMin());
            custom.setEnglishAve(cgrades.getEnglishAve());
            custom.setPoliticsMax(cgrades.getPoliticsMax());
            custom.setPoliticsMin(cgrades.getPoliticsMin());
            custom.setPoliticsAve(cgrades.getPoliticsAve());
            custom.setHistoryMax(cgrades.getHistoryMax());
            custom.setHistoryMin(cgrades.getHistoryMin());
            custom.setHistoryAve(cgrades.getHistoryAve());
            custom.setGeographyMax(cgrades.getGeographyMax());
            custom.setGeographyMin(cgrades.getGeographyMin());
            custom.setGeographyAve(cgrades.getGeographyAve());
            custom.setBiologyAve(cgrades.getBiologyAve());
            custom.setBiologyMax(cgrades.getBiologyMax());
            custom.setBiologyMin(cgrades.getBiologyMin());
            custom.setChemistryAve(cgrades.getChemistryAve());
            custom.setChemistryMax(cgrades.getChemistryMax());
            custom.setChemistryMin(cgrades.getChemistryMin());
            custom.setPhysicsMax(cgrades.getPhysicsMax());
            custom.setPhysicsMin(cgrades.getPhysicsMin());
            custom.setPhysicsAve(cgrades.getPhysicsAve());
            custom.setMusicAve(cgrades.getMusicAve());
            custom.setMusicMin(cgrades.getMusicMin());
            custom.setMusicMax(cgrades.getMusicMax());
            custom.setArtsMax(cgrades.getArtsMax());
            custom.setArtsMin(cgrades.getArtsMin());
            custom.setArtsAve(cgrades.getArtsAve());
            custom.setSportsMax(cgrades.getSportsMax());
            custom.setSportsMin(cgrades.getSportsMin());
            custom.setSportsAve(cgrades.getSportsAve());

            customList.add(custom);

        }

        //用Pagehelper分页助手进行分页
        PageHelper.startPage(page,limit);
        //对studentGradesCustomList进行分页
        PageInfo pageInfo = new PageInfo<>(customList);

        List resultList = pageInfo.getList();

        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();

        return result;


    }


}
