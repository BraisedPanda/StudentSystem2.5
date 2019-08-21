package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.model.po.*;
import com.braisedpanda.shirotest.biz.PermissionBiz;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public String insertRole2(Role role, HttpServletRequest request, Model model){
        permissionBiz.insertRole(role,request);

        model.addAttribute("msg","添加角色成功");

        return "menu/msg";

    }

    //跳转到授予权限的界面
    @RequestMapping("toaddpermission")
    public ModelAndView  toaddpermission2(){
        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = permissionService.getAllRole();

        modelAndView.addObject(roleList);

        modelAndView.setViewName("permission/addpermission");

        return modelAndView;
    }


    /**
     * 根据uid查找所对应的角色
     * @param uid
     * @param model
     * 1、根据传入的uid值了，在userrole表中查询
     * 2、根据有无角色，有无用户进行判断返回
     */

    @ResponseBody
    @RequestMapping("findrolebyid/{uid}")

    public List<UserRole> findrolebyid(@PathVariable("uid") String uid, Model model){
        List<UserRole> userRoleList = permissionService.getRoleById(uid);
        User user = userService.getUserByUid(Integer.parseInt(uid));
        if(userRoleList !=null && userRoleList.size()>0){
            model.addAttribute("roleList", userRoleList);
        }else if(user!=null){ //用户存在，但是没有角色
            UserRole role = new UserRole();
            role.setRole("无");
            role.setUsername(user.getUsername());
            userRoleList.add(role);
            model.addAttribute("roleList", userRoleList);
        }else{  //用户名和角色都不存在
            UserRole role = new UserRole();
            role.setRole("无");
            role.setUsername("无");
            userRoleList.add(role);
            model.addAttribute("roleList", userRoleList);
        }

        return userRoleList;
    }


    /**
     * 根据传入的uid值新增权限
     * @param uid
     * @param request
     * @param model
     *1、若输入的uid不存在，提示用户不存在
     *2、若没有选择任意一个权限，提示选择权限
     *3、操作正常后，把相关数据存入数据库中
     */

    @RequestMapping("addpermission")
    public String addpermission2(int uid,HttpServletRequest request,Model model){
        User user = userService.getUserByUid(uid);

        if(user == null){
            model.addAttribute("msg","**该用户不存在，请检查id是否输入正确");
            List<Role> roleList = permissionService.getAllRole();
            model.addAttribute(roleList);
            return "permission/addpermission";
        }
        //先清空原先有的数据,在表userRole中
        permissionService.deleteRoleByUid(uid);
        //在userRole中，添加相关的数据
        String[] roles = request.getParameterValues("role");
        if(roles ==null || roles.length==0){
            model.addAttribute("msg","***请选择至少一个角色");
            List<Role> roleList = permissionService.getAllRole();
            model.addAttribute(roleList);
            return "permission/addpermission";
        }else
            for (String roleId:
                    roles) {
                Role role = permissionService.getRoleByroleId(roleId);
                String uRId = UUID.randomUUID()+"";
                uRId = uRId.replace("-","");
                UserRole userRole = new UserRole();
                userRole.setURId(uRId);
                userRole.setRoleDescribe(role.getRoleDescribe());
                userRole.setRole(role.getRole());
                userRole.setUid(user.getUid());
                userRole.setUsername(user.getUsername());
                userRole.setRoleId(role.getRoleId());
                permissionService.insertUserRole(userRole);

            }
        model.addAttribute("msg","操作成功");

        return "menu/msg";
    }


    //查询表rolePermission表中所有内容
    @RequestMapping("allpermission")
    public @ResponseBody String allpermission2(int page,int limit){

        String result = permissionBiz.allpermission(page,limit);

        return result;

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
        ModelAndView modelAndView = new ModelAndView();
        List<RolePermission> rolePermissionlist =  permissionService.getRolePermissionById(roleId);

        List<Permission> permissionList= permissionService.getAllPermission();

        modelAndView.addObject("permissionList",permissionList);

        modelAndView.addObject("rolePermission",rolePermissionlist.get(0));

        modelAndView.setViewName("permission/editRolePermission");
        return modelAndView;
    }


    //编辑角色权限信息
    @RequestMapping("editrolePermission")
    public String edit_role_perission2(RolePermission rolePermission, HttpServletRequest request, Model model ){
       permissionBiz.edit_role_perission(rolePermission,request);
        model.addAttribute("msg","修改用户权限成功");

        return "menu/msg";

    }


    //跳转到新增角色权限表
    @RequestMapping("torole")
    public ModelAndView torole2(){
        ModelAndView modelAndView = new ModelAndView();

        List<Permission> permissionList= permissionService.getAllPermission();

        modelAndView.addObject("permissionList",permissionList);

        modelAndView.setViewName("permission/role");

        return modelAndView;
    }

    //查询表role表中所有内容
    @RequestMapping("allrole")
    public @ResponseBody String allrole2(int page,int limit){

        String result = permissionBiz.allrole(page,limit);

        return result;

    }

    //根据roleId删除role表中的role
    @ResponseBody
    @RequestMapping("permission/deleterole/{roleId}")

    public void deleterole(@PathVariable("roleId") String roleId){
        permissionService.deleteRoleByroleId(roleId);
    }

}
