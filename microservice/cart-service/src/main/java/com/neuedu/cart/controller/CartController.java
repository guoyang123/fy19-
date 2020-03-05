package com.neuedu.cart.controller;

import com.neuedu.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    ProductService productService;

 @RequestMapping("/cart")
 public  String  list(){


    return  productService.calllistfromproduct("phone");

 }


}
