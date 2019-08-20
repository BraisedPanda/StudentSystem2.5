package com.braisedpanda.shirotest.biz;

import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.bean.UserRole;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserBiz {

    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;


    //查找所有的用户

    public ModelAndView allUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.listUsers();

        modelAndView.addObject("useList",userList);
        modelAndView.setViewName("index");
       return modelAndView;
    }

    //用户注册

    public String regist(User user,Model model,String activeCode){
        if(activeCode ==null || activeCode.length()==0){
            user.setActiveCode("0");
        }
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");
        userService.addUser(user);

        model.addAttribute("user",user);

        return "redirect:/";
    }

    //用户登录

    public ModelAndView login(String username, String password, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();


        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            modelAndView.addObject("tips","*未知账户~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (IncorrectCredentialsException ice) {
            modelAndView.addObject("tips","*密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (LockedAccountException lae) {
            modelAndView.addObject("tips","*账户已锁定~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (ExcessiveAttemptsException eae) {
            modelAndView.addObject("tips","*用户名或密码错误次数过多~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (AuthenticationException ae) {
            modelAndView.addObject("tips","*用户名或密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        }
        if (subject.isAuthenticated()) {
            User user = userService.getUser(username,password);
            session.setAttribute("user",user);
            modelAndView.setViewName("menu/main");
            return modelAndView;
        } else {
            token.clear();
            modelAndView.addObject("tips","*未知账户~");
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }





    //查找所有用户(使用分页助手)

    public ModelAndView  userlist(@PathVariable("startPage") int startPage){
        ModelAndView modelAndView = new ModelAndView();
        int totalCount = userService.listUsers().size();
        PageHelper.startPage(startPage,8);
        List<User> userList1 = userService.listUsers();
        int totalPage ;
        if(totalCount % 8 ==0){
            totalPage = totalCount / 8;
        }else{
            totalPage = totalCount / 8 +1 ;
        }


        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
        List<User> userList = userPageInfo.getList();

        modelAndView.addObject("userList",userList);
        //向前端页面传入总页数和当前页数，方便操作
        modelAndView.addObject("totalPage",totalPage);
        modelAndView.addObject("startPage",startPage);
        modelAndView.setViewName("user/userlist");

        return modelAndView;
    }

    //修改用户信息(回显)


    public ModelAndView getuser(@PathVariable("uid") int uid){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserByUid(uid);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }
    //修改用户信息

    public ModelAndView  edituser(User user){
        int startPage = 1;

        userService.edit(user);
        ModelAndView modelAndView = new ModelAndView();
        int totalCount = userService.listUsers().size();
        PageHelper.startPage(startPage,8);
        List<User> userList1 = userService.listUsers();
        int totalPage ;
        if(totalCount % 8 ==0){
            totalPage = totalCount / 8;
        }else{
            totalPage = totalCount / 8 +1 ;
        }


        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
        List<User> userList = userPageInfo.getList();

        modelAndView.addObject("userList",userList);
        //向前端页面传入总页数和当前页数，方便操作
        modelAndView.addObject("totalPage",totalPage);
        modelAndView.addObject("startPage",startPage);
        modelAndView.setViewName("user/userlist");

        return modelAndView;
    }
    //编辑用户(后台编辑)
    //修改用户信息

    public String user_edit(User user){


        userService.edit(user);


        return "user/success";
    }

    //新增用户（后台添加）


    public ModelAndView adduser(User user,Model model,String activeCode){
        if(activeCode ==null || activeCode.length()==0){
            user.setActiveCode("0");
        }
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");
        userService.addUser(user);

        model.addAttribute("user",user);
        int startPage = 1;

        userService.edit(user);
        ModelAndView modelAndView = new ModelAndView();
        int totalCount = userService.listUsers().size();
        PageHelper.startPage(startPage,8);
        List<User> userList1 = userService.listUsers();
        int totalPage ;
        if(totalCount % 8 ==0){
            totalPage = totalCount / 8;
        }else{
            totalPage = totalCount / 8 +1 ;
        }


        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
        List<User> userList = userPageInfo.getList();

        modelAndView.addObject("userList",userList);
        //向前端页面传入总页数和当前页数，方便操作
        modelAndView.addObject("totalPage",totalPage);
        modelAndView.addObject("startPage",startPage);
        modelAndView.setViewName("user/userlist");

        return modelAndView;


    }
    //添加用户(layui弹出层)
    //新增用户（后台添加）

    public String add_user(User user){
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");

        userService.addUser(user);


        return "user/success";


    }





    public  Map<String,Object> testtable(int page,int limit){
        int count = userService.listUsers().size();
        PageHelper.startPage(page,limit);
        List<User> userList1 = userService.listUsers();

        PageInfo<User> userPageInfo = new PageInfo<>(userList1);

        List<User> userList = userPageInfo.getList();
        for (User user:
             userList) {
            List<UserRole> userRoleList = permissionService.getRoleById(user.getUid()+"");
            StringBuffer sb = new StringBuffer();
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
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",userList);
        return resultMap;

    }





    //图片上传测试

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


    //修改用户信息(回显)


    public ModelAndView userinfo(HttpSession session){
        User user1 = (User)session.getAttribute("user");
        int uid = user1.getUid();
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserByUid(uid);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/userlist2");
        return modelAndView;
    }








}
