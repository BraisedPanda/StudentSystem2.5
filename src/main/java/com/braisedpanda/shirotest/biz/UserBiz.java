package com.braisedpanda.shirotest.biz;

import com.braisedpanda.shirotest.model.po.User;
import com.braisedpanda.shirotest.model.po.UserRole;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;
import com.braisedpanda.shirotest.utils.ResultMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    /**
     * 测试查找用户（此方法废弃）
     * @param
     * @return
     */
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


    /**
     * 用户角色表（userrole）
     * 查找userrole表中数据，在前台进行展示
     * @param page
     * @param limit

     */
    public  Map<String,Object> testtable(int page,int limit){
        int count = userService.listUsers().size();
        PageHelper.startPage(page,limit);
        List<User> userList1 = userService.listUsers();

        for (User user:
                userList1) {
            List<UserRole> userRoleList = permissionService.getRoleById(user.getUid()+"");
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
        ResultMapUtil mapUtil = new ResultMapUtil();
        Map resultMap = mapUtil.getResultMap(count,userList1);

        return resultMap;

    }


    /**
     * 图片上传测试
     * @param file
     * @param request
     *
     */
    public Map upload(MultipartFile file,HttpServletRequest request){

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
                return map;
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
        return map;

    }


}
