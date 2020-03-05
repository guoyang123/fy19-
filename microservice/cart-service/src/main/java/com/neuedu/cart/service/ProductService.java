package com.neuedu.cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product") // product --> product服务的instance-id
public interface ProductService {

    @GetMapping("/product/list")
    public String  calllistfromproduct(@RequestParam("keyword") String keyword);
}
