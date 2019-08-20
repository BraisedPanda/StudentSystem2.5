package com.braisedpanda.shirotest.biz;

import com.braisedpanda.shirotest.bean.po.*;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PermissionBiz {

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;




    //新增角色

    public String insertRole(Role role, HttpServletRequest request, Model model){
        //添加角色信息

        String roleId = UUID.randomUUID()+"";
        roleId = roleId.replace("-","");
        role.setRoleId(roleId);

        permissionService.insertRole(role);

        String[] s = request.getParameterValues("permission");
        for (String s1:
             s) {
           Permission permission =  permissionService.getPermissionById(s1);
            RolePermission rp = new RolePermission();
            String rPId = UUID.randomUUID()+"";
            rPId = rPId.replace("-","");

            rp.setRPId(rPId);
            rp.setPermissionId(permission.getPermissionId());
            rp.setPermission(permission.getPermission());
            rp.setPermissionDescribe(permission.getPermissionDescribe());
            rp.setRoleId(roleId);
            rp.setRole(role.getRole());
            rp.setRoleDescribe(role.getRoleDescribe());

            permissionService.insertRolePermission(rp);



        }
        model.addAttribute("msg","添加角色成功");
        return "menu/msg";
    }

    //跳转到授予权限的界面

    public ModelAndView  toaddpermission(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = permissionService.getAllRole();
        modelAndView.addObject(roleList);
        modelAndView.setViewName("permission/addpermission");
        return modelAndView;
    }

    //根据uid查找所对应的角色

    @Cacheable(value="permission" , key="#uid")
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


    //新增权限

    public String addpermission(int uid,HttpServletRequest request,Model model){
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

    public @ResponseBody Map<String,Object> allpermission(int page,int limit){


        List<RolePermission> rolePermissionList = permissionService.listRolePermission();
        int count = rolePermissionList.size();
        PageHelper.startPage(page,limit);

        List<RolePermission> rolePermissionList1 = permissionService.listRolePermission();

        PageInfo<RolePermission> rolePermissionPageInfo = new PageInfo<>(rolePermissionList1);

        List<RolePermission> rolePermissionlist = rolePermissionPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",rolePermissionlist);
        return resultMap;

    }



    //编辑角色对应的权限

    public ModelAndView permission_toedit(@PathVariable("roleId")String roleId){
        ModelAndView modelAndView = new ModelAndView();
        List<RolePermission> rolePermissionlist =  permissionService.getRolePermissionById(roleId);
        List<Permission> permissionList= permissionService.getAllPermission();
        modelAndView.addObject("permissionList",permissionList);

       modelAndView.addObject("rolePermission",rolePermissionlist.get(0));

       modelAndView.setViewName("permission/editRolePermission");
       return modelAndView;
    }

    //编辑角色权限信息

    public String edit_role_perission(RolePermission rolePermission, HttpServletRequest request, Model model ){
        //1、根据roleId删除原先角色所有的权限
        String roleId = rolePermission.getRoleId();

        permissionService.deleteRolePermissionByroleId(roleId);

        //2、根据表单内容添加角色对应的权限

        String[] permissionList = request.getParameterValues("permission");

        for (String s1:
                permissionList) {
            Permission permission =  permissionService.getPermissionById(s1);
            RolePermission rolePermission1 = new RolePermission();
            String rPId = UUID.randomUUID()+"";
            rPId = rPId.replace("-","");
            rolePermission1.setRPId(rPId);
            rolePermission1.setPermissionId(permission.getPermissionId());
            rolePermission1.setPermission(permission.getPermission());
            rolePermission1.setPermissionDescribe(permission.getPermissionDescribe());
            rolePermission1.setRoleId(roleId);
            rolePermission1.setRole(rolePermission.getRole());
            rolePermission1.setRoleDescribe(rolePermission.getRoleDescribe());

            //在role表中更新role的相关权限、名称等信息
            Role role = new Role();
            role.setRoleId(roleId);
            role.setRoleDescribe(rolePermission.getRoleDescribe());
            role.setRole(rolePermission.getRole());
            permissionService.updateRole(role);

            permissionService.insertRolePermission(rolePermission1);
        }

       model.addAttribute("msg","修改用户权限成功");

        return "menu/msg";

    }
    //跳转到新增角色权限表

    public ModelAndView torole(){
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList= permissionService.getAllPermission();
        modelAndView.addObject("permissionList",permissionList);

        modelAndView.setViewName("permission/role");
        return modelAndView;
    }

    //查询表role表中所有内容

    public @ResponseBody Map<String,Object> allrole(int page,int limit){

        List<Role> roleList = permissionService.getAllRole();
        int count = roleList.size();
        PageHelper.startPage(page,limit);

        List<Role> roleList1 = permissionService.getAllRole();

        PageInfo<Role> rolePageInfo = new PageInfo<>(roleList1);

        List<Role> roleList2 = rolePageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",roleList2);
        return resultMap;

    }

}

