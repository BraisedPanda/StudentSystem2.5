package com.braisedpanda.shirotest.biz;

import com.braisedpanda.shirotest.model.po.*;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;
import com.braisedpanda.shirotest.utils.ResultMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PermissionBiz {

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;


    /**
     * 新增角色
     * @param role
     * @param request
     * 1、添加角色到role表中
     * 2、根据前端的权限选项，在permission表中添加相关的权限信息
     */

    public void insertRole(Role role, HttpServletRequest request){
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

    }


    /**
     * 根据uid查找所对应的角色
     * @param uid
     * @param model
     * 1、根据传入的uid值了，在userrole表中查询
     * 2、根据有无角色，有无用户进行判断返回
     */

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






    //查询表rolePermission表中所有内容
    public @ResponseBody Map<String,Object> allpermission(int page,int limit){


        List<RolePermission> rolePermissionList = permissionService.listRolePermission();
        int count = rolePermissionList.size();
        PageHelper.startPage(page,limit);

        List<RolePermission> rolePermissionList1 = permissionService.listRolePermission();

        ResultMapUtil mapUtil = new ResultMapUtil();

        Map resultMap = mapUtil.getResultMap(count,rolePermissionList1);

        return resultMap;

    }


    /**
     * 编辑角色权限信息
     * @param rolePermission
     * @param request

     * 1、根据roleId删除原先角色所有的权限
     * 2、根据表单内容添加角色对应的权限
     * 3、在role表中更新role的相关权限、名称等信息
     */
    public void edit_role_perission(RolePermission rolePermission, HttpServletRequest request){
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

            //3、在role表中更新role的相关权限、名称等信息
            Role role = new Role();
            role.setRoleId(roleId);
            role.setRoleDescribe(rolePermission.getRoleDescribe());
            role.setRole(rolePermission.getRole());
            permissionService.updateRole(role);

            permissionService.insertRolePermission(rolePermission1);
        }



    }


    //查询表role表中所有内容

    public  Map<String,Object> allrole(int page,int limit){

        List<Role> roleList = permissionService.getAllRole();
        int count = roleList.size();
        PageHelper.startPage(page,limit);

        List<Role> roleList1 = permissionService.getAllRole();

        ResultMapUtil resultMapUtil = new ResultMapUtil();

        Map resultMap = resultMapUtil.getResultMap(count,roleList1);

        return resultMap;

    }

}

