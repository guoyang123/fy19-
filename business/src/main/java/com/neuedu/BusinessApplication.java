package com.neuedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.neuedu.dao")
@EnableScheduling //开启定时任务
public class BusinessApplication {

    public static void main(String[] args) {

        SpringApplication.run(BusinessApplication.class, args);

    }

}
