package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.mapper.ClassMapper;
import com.braisedpanda.shirotest.model.po.SClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JumpController {
    //跳转到注册界面
    @RequestMapping("toregist")
    public String toregist(){
        return "user/regist";
    }

    //跳转到登录界面
    @RequestMapping("tologin")
    public String tologin(){
        return "index";
    }

   //主页内容
    @RequestMapping("index")
    public String index(){
        return "menu/main";
    }

    //上传测试代码
    @RequestMapping("uploadtest")
    public String upload(){
        return "user/upload";
    }

    //无权限时，跳转界面
    @RequestMapping("notRole")
    public String testr(){
        return "menu/nopermission";
    }

    //跳转到登录界面
    @RequestMapping("login")
    public String toologin(){
        return "redirect:/";
    }

    //显示学生列表
    @RequestMapping("tostudentlist")
    public String tostudentlist(){
        return "student/allstudent";
    }

    //查询所有的权限
    @RequestMapping("toallpermission")
    public String toallpermission(){
        return "permission/allrolePermission";
    }

    //跳转到左侧菜单栏
    @RequestMapping("toleft")
    public String toleft(){
        return "menu/left";
    }

    //跳转到所有角色
    @RequestMapping("toallrole")
    public String toallrole(){
        return "permission/allrole";
    }

    //跳转到所有班级成绩
    @RequestMapping("toclassgrades")
    public String toclassgrades(){
        return "class/classgrades";
    }

    //跳转到权限...
    @RequestMapping("topermission")
    public String topermission(){
        return null;
    }

    @Autowired
    ClassMapper classMapper;

//    @ResponseBody
//    @RequestMapping("testtk")
//    public List<SClass> testtk(){
//        List<SClass> classList = classMapper.selectAll();
//        return classList;
//     }

}
