package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.po.User;
import com.braisedpanda.shirotest.biz.UserBiz;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    UserBiz userBiz;


    //查找所有的用户
    @RequestMapping("/alluser")
    public ModelAndView allUser2(){

        ModelAndView modelAndView = userBiz.allUser();

        return modelAndView;
    }

    //用户注册
    @RequestMapping("/regist")
    public String regist2(User user,Model model,String activeCode){

        String str = userBiz.regist(user,model,activeCode);

        return str;
    }

    //用户登录
    @PostMapping("/login")
    public ModelAndView login2(String username, String password, HttpSession session){
        ModelAndView modelAndView = userBiz.login(username,password,session);
        return modelAndView;
    }

//
    @GetMapping("test1")
    public String test1(){
        return "user/userlist";
    }

    //查找所有用户(使用分页助手)
    @RequiresPermissions("finds")
    @RequestMapping("/userlist/{startPage}")
    public ModelAndView  userlist2(@PathVariable("startPage") int startPage){
        ModelAndView modelAndView = userBiz.userlist(startPage);


        return modelAndView;
    }
    //删除用户
    @RequestMapping("/delete/{uid}")
    public String delete(@PathVariable("uid") String uid){
        userService.delete(uid);

        return "user/blank";
    }

    //修改用户信息(回显)

    @RequestMapping("edituser/{uid}")
    public ModelAndView getuser2(@PathVariable("uid") int uid){
        ModelAndView modelAndView = userBiz.getuser(uid);

        return modelAndView;
    }

    //修改用户信息
    @RequestMapping("user/edit")
    public ModelAndView  edituser2(User user){
        ModelAndView modelAndView = userBiz.edituser(user);
        return modelAndView;
    }


    //编辑用户(后台编辑)
    //修改用户信息
    @RequestMapping("user_edit")
    public String user_edit(User user){


        userService.edit(user);


        return "user/success";
    }

    //新增用户（后台添加）

    @RequestMapping("/adduser")
    public ModelAndView adduser2(User user,Model model,String activeCode){
        ModelAndView modelAndView = userBiz.adduser(user,model,activeCode);
        return modelAndView;


    }
    //添加用户(layui弹出层)
    //新增用户（后台添加）
    @RequestMapping("/add_user")
    public String add_user2(User user){

       String str =  userBiz.add_user(user);

       return str;


    }
    //退出登录
    @RequestMapping("/quite")
    public String quite(HttpSession session){
        session.removeAttribute("user");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

        return "redirect:/";
    }



    @RequestMapping("user/table")
    public @ResponseBody Map<String,Object> testtable2(int page,int limit){
        Map<String,Object> map = userBiz.testtable(page,limit);

        return map;

    }



    @RequestMapping("/userlist2")
    public  String userlist2(){


        return "user/userlist2";
    }

    //图片上传测试
    @ResponseBody
    @RequestMapping("upload")
    public Map upload2(MultipartFile file,HttpServletRequest request){
        Map map = userBiz.upload(file,request);

        return map;

    }


    //修改用户信息(回显)

    @RequestMapping("userinfo")
    public ModelAndView userinfo2(HttpSession session){
        ModelAndView modelAndView = userBiz.userinfo(session);

        return modelAndView;
    }


}
