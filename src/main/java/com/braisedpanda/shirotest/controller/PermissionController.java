package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.biz.PermissionBiz;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PermissionController {

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;
    @Autowired
    PermissionBiz permissionBiz;



    //新增角色
    @RequestMapping("insertRole")
    public String insertRole2(Role role, HttpServletRequest request,Model model){
        String str = permissionBiz.insertRole(role,request,model);


        return str;
    }

    //跳转到授予权限的界面
    @RequestMapping("toaddpermission")
    public ModelAndView  toaddpermission2(){
        ModelAndView modelAndView = permissionBiz.toaddpermission();

        return modelAndView;
    }

    //根据uid查找所对应的角色
    @ResponseBody
    @RequestMapping("findrolebyid/{uid}")
    @Cacheable(value="permission" , key="#uid")
    public List<UserRole> findrolebyid2(@PathVariable("uid") String uid, Model model){
        List<UserRole> userRoleList = permissionBiz.findrolebyid(uid,model);
        return userRoleList;
    }


    //新增权限
    @RequestMapping("addpermission")
    public String addpermission2(int uid,HttpServletRequest request,Model model){
        String str = permissionBiz.addpermission(uid,request,model);


        return str;
    }

    //查询表rolePermission表中所有内容
    @RequestMapping("allpermission")
    public @ResponseBody Map<String,Object> allpermission2(int page,int limit){

        Map<String,Object> map = permissionBiz.allpermission(page,limit);

        return map;

    }

    //删除rolePermission中，角色所有的权限
    @ResponseBody
    @RequestMapping("permission/delete/{rPId}")
    public void deleteRolePermissionById(@PathVariable("rPId")String rPId){
        permissionService.deleteRolePermissionById(rPId);
    }

    //编辑角色对应的权限
    @RequestMapping("permission/toedit/{roleId}")
    public ModelAndView permission_toedit2(@PathVariable("roleId")String roleId){
        ModelAndView modelAndView = permissionBiz.permission_toedit(roleId);

       return modelAndView;
    }

    //编辑角色权限信息
    @RequestMapping("editrolePermission")
    public String edit_role_perission2(RolePermission rolePermission, HttpServletRequest request, Model model ){
       String str = permissionBiz.edit_role_perission(rolePermission,request,model);

        
        return str;

    }
    //跳转到新增角色权限表
    @RequestMapping("torole")
    public ModelAndView torole2(){
        ModelAndView modelAndView = permissionBiz.torole();

        return modelAndView;
    }

    //查询表role表中所有内容
    @RequestMapping("allrole")
    public @ResponseBody Map<String,Object> allrole2(int page,int limit){
        Map<String,Object> map = permissionBiz.allrole(page,limit);

        return map;

    }

    //根据roleId删除role表中的role
    @ResponseBody
    @RequestMapping("permission/deleterole/{roleId}")
    public void deleterole(@PathVariable("roleId") String roleId){
        permissionService.deleteRoleByroleId(roleId);
    }

}
