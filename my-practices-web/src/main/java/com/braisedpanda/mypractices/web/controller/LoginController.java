package com.braisedpanda.mypractices.web.controller;


import com.braisedpanda.mypractices.commons.model.CommonsResult;
import com.braisedpanda.mypractices.commons.model.User;
import com.braisedpanda.mypractices.commons.utils.DateUtils;
import com.braisedpanda.mypractices.commons.utils.MD5Utils;
import com.braisedpanda.mypractices.web.config.security.SecurityUser;
import com.braisedpanda.mypractices.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @program: my-practices
 * @description: 登录有关的操作
 * @author: chenzhen
 * @create: 2019-12-16 10:39
 **/
@Api(tags = "登录相关配置", description = "提供用户登录、注册相关的方法")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @ApiOperation("跳转到注册页面")
    @GetMapping("/regist")
    public ModelAndView toRegist(){
        return new ModelAndView("regist");
    }

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("login");
    }
    @ApiOperation("跳转到登录页面")
    @GetMapping("/login")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }
    
    /** 
    * @Description: 注册新用户
    * @Param: User 接收的user对象
    * @Date: 2019/12/16 0016 
    */
    @ApiOperation("注册用户")
    @PostMapping("/regist")
    public ModelAndView regist(Model model, User user){
        String email = user.getEmail();
        CommonsResult result1 = userService.checkEmail(email);
        if(result1.getCode() == 500){
            model.addAttribute("msg","*该邮箱已经被注册");
            model.addAttribute("email",email);
            return new ModelAndView("regist");
        }
        String pwd = user.getPassword();
        String md5Pwd = MD5Utils.encrypt(pwd);
        user.setPassword(md5Pwd);
        user.setCreateTime(DateUtils.currentStandardDate());
        user.setStatus(0);
        CommonsResult result = userService.insertUser(user);
        model.addAttribute("code",result.getCode());
        return new ModelAndView("msg");
    }
    @ApiOperation("登录用户")
    @PostMapping("/login")
    public ModelAndView login(){

        return new ModelAndView("index");
    }


}
