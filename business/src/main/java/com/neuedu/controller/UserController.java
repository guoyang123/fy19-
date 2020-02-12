package com.neuedu.controller;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.UserMapper;
import com.neuedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    UserMapper userMapper;
    @Value("${user.username}")
    private  String username;


    /**
     * 访问id=1的用户信息
     *
     * http://xxx:8080/user?id=1
     * */

    @RequestMapping(value = {"/user","/info"})
    @ResponseBody
    public User findUserById(@RequestParam("id") Integer userid){

        User user=new User();

        user.setId(userid);
        user.setUsername(username);

        return user;

    }

    /**
     * 访问id=1的用户信息
     *
     * http://xxx:8080/user/1/zhangsan
     * */

    @RequestMapping("/user/{id}/{username}")
    @ResponseBody
    public  User findUserById2(@PathVariable("id")  Integer userid,
                               @PathVariable("username") String username){
        User user=new User();

        user.setId(userid);
        user.setUsername(username);

        return user;

    }



    /**
     *
     * 测试mybatis
     * */

    @RequestMapping("/mybatis/{userid}")
    @ResponseBody
    public ServerResponse findUser(@PathVariable("userid") int userid){


       User user= userMapper.selectByPrimaryKey(userid);

       if(user!=null){
         return  ServerResponse.serverResponseBySucess(null,user);
       }


       return ServerResponse.serverResponseByFail(1,"id不存在");
    }



}
