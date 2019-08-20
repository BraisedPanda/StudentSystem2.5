package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="student")
public class Student implements Serializable {
    @Id
    private String stuId;              //学生学号
    private String stuName;            //姓名
    private String stuPassword;        //密码
    private String stuEmail;           //邮箱
    private String stuIdCard;         //身份证号码
    private String stuSex;             //性别
    private String stuBirthday;        //生日
    private String nationName;           //名族
    private String stuStatus;          //入学状态
    private String stuAge;             //年龄
    private String classId;            //班级标号
    private String stuenRollmentTime; //入学时间
    private String stuPolitical;       //政治面貌
    private String stuAddress;         //家庭住址
    private String stuImage;           //相片



    private Nation nation;


}
