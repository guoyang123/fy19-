package com.neuedu.cart.controller;

import com.neuedu.cart.pojo.UserInfo;
import com.neuedu.cart.service.ProductService;
import com.neuedu.cart.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CartController {

    @Autowired
    ProductService productService;

 @RequestMapping("/cart")
 public  String  list(){


    return  productService.calllistfromproduct("phone");

 }


 @Autowired
 SSOService ssoService;
 @RequestMapping("/cart/add")
 public String add(HttpSession session){

     UserInfo userInfo=(UserInfo)session.getAttribute("user");
     if(userInfo==null){
         //子系统未登录
         //调用sso-server

         String result=ssoService.sso_login("aa");
         System.out.println(result);
     }

     return null;
 }



}
