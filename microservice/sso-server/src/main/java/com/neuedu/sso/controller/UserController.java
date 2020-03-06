package com.neuedu.sso.controller;

import com.neuedu.sso.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sso/")
public class UserController {

    @RequestMapping("login")
    public String login(String callbackurl, HttpSession session){

        System.out.println("=====sso-========start==");
        UserInfo userInfo=(UserInfo)session.getAttribute("user");
        if(userInfo==null){
            //用户未登录
            //加载登录页面
            return "userlogin";
        }
        System.out.println("==========sso already login========");


        return null;
    }

}
