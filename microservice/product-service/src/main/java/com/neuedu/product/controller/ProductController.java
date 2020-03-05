package com.neuedu.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @RequestMapping("/product/list")
     public String  list(String keyword){

         return "product list "+keyword;
     }

}
