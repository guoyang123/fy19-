package com.neuedu.reflect;

import com.neuedu.annotation.Description;
import com.neuedu.pojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationReflect {


    public static void main(String[] args) {


        Class<User> c=User.class;

       boolean result= c.isAnnotationPresent(Description.class);


       if(result){//User类上有Description注解

          Description d=(Description) c.getAnnotation(Description.class);

           System.out.println(d.age());
           System.out.println(d.author());
           System.out.println(d.desc());
       }
    }

}
