package com.neuedu.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/product/list")
     public String  list(String keyword){



         return "product list "+port;
     }

}
