package com.braisedpanda.shirotest.biz;

import com.braisedpanda.shirotest.model.po.*;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.RolePermissionService;
import com.braisedpanda.shirotest.service.RoleService;
import com.braisedpanda.shirotest.service.UserService;
import com.braisedpanda.shirotest.utils.JsonUtils;
import com.braisedpanda.shirotest.utils.PageHelperUtils;

import com.braisedpanda.shirotest.utils.ResultType;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import java.util.UUID;

@Service
public class PermissionBiz {

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    RolePermissionService rolePermissionService;

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

        roleService.insertRole(role);

        String[] s = request.getParameterValues("permission");
        for (String s1:
             s) {
            Permission per =new Permission();
            per.setPermissionId(s1);
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

            rolePermissionService.insertRolePermission(rp);
        }

    }


    /**
    * @Description: 查询表rolePermission表中所有内容
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */
    public String allpermission(int page,int limit){


        int count = rolePermissionService.countRolePermission();

        PageHelper.startPage(page,limit);
        List<RolePermission> rolePermissionList1 = rolePermissionService.listRolePermission();

        List resultList = PageHelperUtils.getResultList(rolePermissionList1);

        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();


        return result;

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

        rolePermissionService.deleteRolePermissionByroleId(roleId);

        //2、根据表单内容添加角色对应的权限

        String[] permissionList = request.getParameterValues("permission");

        for (String s1:
                permissionList) {
            Permission per = new Permission();
            per.setPermissionId(s1);
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
            roleService.updateRole(role);

            rolePermissionService.insertRolePermission(rolePermission1);
        }



    }


    //查询表role表中所有内容

    public  String allrole(int page,int limit){

        int count = roleService.countRole();
        PageHelper.startPage(page,limit);

        List<Role> roleList1 = roleService.selectAllRole();
        PageInfo pageInfo = new PageInfo(roleList1);
        List<Role> resultList = pageInfo.getList();

        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();


        return result;

    }

}

