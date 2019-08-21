package com.braisedpanda.shirotest.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
@Data
@Table(name="student")
public class Student implements Serializable {
    @Id
    @Column(name="stuId")

    private String stuId;              //学生学号
    @Column(name="stuName")
    private String stuName;            //姓名
    @Column(name="stuPassword")
    private String stuPassword;        //密码
    @Column(name="stuEmail")
    private String stuEmail;           //邮箱
    @Column(name="stuIdCard")
    private String stuIdCard;         //身份证号码
    @Column(name="stuSex")
    private String stuSex;             //性别
    @Column(name="stuBirthday")
    private String stuBirthday;        //生日
    @Column(name="nationName")
    private String nationName;           //名族
    @Column(name="stuStatus")
    private String stuStatus;          //入学状态
    @Column(name="stuAge")
    private String stuAge;             //年龄
    @Column(name="classId")
    private String classId;            //班级标号
    @Column(name="stuenRollmentTime")
    private String stuenRollmentTime; //入学时间
    @Column(name="stuPolitical")
    private String stuPolitical;       //政治面貌
    @Column(name="stuAddress")
    private String stuAddress;         //家庭住址
    @Column(name="stuImage")
    private String stuImage;           //相片


    @Transient
    private Nation nation;


}
