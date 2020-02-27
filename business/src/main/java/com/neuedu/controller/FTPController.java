package com.neuedu.controller;

import com.neuedu.ftp.FTPUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FTPController {

    @RequestMapping("/ftp")
    public String uploadFtp(){

        List<File> list=new ArrayList<>();

        File file=new File("/Users/guoyang/Documents/qr-1582532525521.png");

        list.add(file);

        try {
            FTPUtils.uploadFile(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "finish";

    }

}
