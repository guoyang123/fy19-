package com.neuedu.cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sso-server")
public interface SSOService {
    @GetMapping("/sso/login")
    public String  sso_login(@RequestParam("callbackurl")String callbackurl);
}
