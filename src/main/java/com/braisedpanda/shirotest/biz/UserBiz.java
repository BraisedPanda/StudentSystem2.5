package com.braisedpanda.shirotest.biz;

import com.alibaba.fastjson.JSONObject;
import com.braisedpanda.shirotest.model.po.User;
import com.braisedpanda.shirotest.model.po.UserRole;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserRoleService;
import com.braisedpanda.shirotest.service.UserService;
import com.braisedpanda.shirotest.utils.JsonUtils;
import com.braisedpanda.shirotest.utils.PageHelperUtils;

import com.braisedpanda.shirotest.utils.ResultType;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserBiz {

    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserRoleService userRoleService;


    /**
     * 用户角色表（userrole）
     * 查找userrole表中数据，在前台进行展示
     * @param page
     * @param limit

     */
    public  String testtable(int page,int limit){
        int count = userService.selectAllUser().size();
        PageHelper.startPage(page,limit);
        List<User> userList1 = userService.selectAllUser();

        for (User user:
                userList1) {
            List<UserRole> userRoleList = userRoleService.selectUserRoleByUid(user.getUid());
            StringBuffer sb = new StringBuffer();
            //如果没有角色，追加【无角色】样式
            if(userRoleList ==null || userRoleList.size()==0){
                user.setRoleList("无角色");
            }
            else {
                for (UserRole userRole :
                        userRoleList) {
                    sb.append("【");
                    sb.append(userRole.getRole());
                    sb.append("】");

                }
                user.setRoleList(sb.toString());
            }



        }
        List resultList = PageHelperUtils.getResultList(userList1);
        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();


        return result;

    }


    /**
     * 图片上传测试
     * @param file
     * @param request
     *
     */
    public String upload(MultipartFile file,HttpServletRequest request){

        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                Date date = new Date();
                String uuid = UUID.randomUUID()+"";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                String filepath = "D:\\StudentManagementSystem\\src\\main\\resources\\static\\images\\" + dateStr+"\\"+uuid+"." + prefix;


                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map2=new HashMap<>();
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("data",map2);
                map2.put("src","/images/"+ dateStr+"/"+uuid+"." + prefix);
                JSONObject json = new JSONObject(map);
                return json.toJSONString();
            }

        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");

        JSONObject json = new JSONObject(map);

        return json.toJSONString();

    }



    /**************废弃的方法******************/


//    public ModelAndView  userlist(@PathVariable("startPage") int startPage){
//        ModelAndView modelAndView = new ModelAndView();
//        int totalCount = userService.listUsers().size();
//        PageHelper.startPage(startPage,8);
//        List<User> userList1 = userService.listUsers();
//        int totalPage ;
//        if(totalCount % 8 ==0){
//            totalPage = totalCount / 8;
//        }else{
//            totalPage = totalCount / 8 +1 ;
//        }
//
//
//        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
//        List<User> userList = userPageInfo.getList();
//
//        modelAndView.addObject("userList",userList);
//        //向前端页面传入总页数和当前页数，方便操作
//        modelAndView.addObject("totalPage",totalPage);
//        modelAndView.addObject("startPage",startPage);
//        modelAndView.setViewName("user/userlist");
//
//        return modelAndView;
//    }
//
//
//
//
//    //修改用户信息(此方法废弃)
//
//    public ModelAndView  edituser(User user){
//        int startPage = 1;
//
//        userService.edit(user);
//        ModelAndView modelAndView = new ModelAndView();
//        int totalCount = userService.listUsers().size();
//        PageHelper.startPage(startPage,8);
//        List<User> userList1 = userService.listUsers();
//        int totalPage ;
//        if(totalCount % 8 ==0){
//            totalPage = totalCount / 8;
//        }else{
//            totalPage = totalCount / 8 +1 ;
//        }
//
//
//        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
//        List<User> userList = userPageInfo.getList();
//
//        modelAndView.addObject("userList",userList);
//        //向前端页面传入总页数和当前页数，方便操作
//        modelAndView.addObject("totalPage",totalPage);
//        modelAndView.addObject("startPage",startPage);
//        modelAndView.setViewName("user/userlist");
//
//        return modelAndView;
//    }


    //新增用户（后台添加）

//
//    public ModelAndView adduser(User user,Model model,String activeCode){
//        if(activeCode ==null || activeCode.length()==0){
//            user.setActiveCode("0");
//        }
//        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");
//        userService.addUser(user);
//
//        model.addAttribute("user",user);
//        int startPage = 1;
//
//        userService.edit(user);
//        ModelAndView modelAndView = new ModelAndView();
//        int totalCount = userService.listUsers().size();
//        PageHelper.startPage(startPage,8);
//        List<User> userList1 = userService.listUsers();
//        int totalPage ;
//        if(totalCount % 8 ==0){
//            totalPage = totalCount / 8;
//        }else{
//            totalPage = totalCount / 8 +1 ;
//        }
//
//
//        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
//        List<User> userList = userPageInfo.getList();
//
//        modelAndView.addObject("userList",userList);
//        //向前端页面传入总页数和当前页数，方便操作
//        modelAndView.addObject("totalPage",totalPage);
//        modelAndView.addObject("startPage",startPage);
//        modelAndView.setViewName("user/userlist");
//
//        return modelAndView;
//

//    }

    /***********废弃的方法******************/


}
