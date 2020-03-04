package com.neuedu.config;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

//@Component
public class FTPConfig {


    @Value("${ftp.ip}")
    private  String  ftpIp;
    @Value("${ftp.user}")
    private String  ftpUser;
    @Value("${ftp.pass}")
    private  String ftpPass;
    @Value("${ftp.port}")
    private  Integer port;



    FTPClient ftpClient=new FTPClient();

    /**
     * 连接ftp
     * */
    public    boolean connectFTPServer() {
        ftpClient=new FTPClient();

        try {
            ftpClient.connect(ftpIp);
            return  ftpClient.login(ftpUser,ftpPass);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("=====connect fail...");
        }
        return false;

    }

    public  boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        FileInputStream fileInputStream=null;

        if(connectFTPServer()){
            try {
                //切换工作目录到文件所在的目录
                ftpClient.changeWorkingDirectory(remotePath);

                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                for(File file:fileList){
                    fileInputStream=new FileInputStream(file);
                    ftpClient.storeFile(file.getName(),fileInputStream);
                }
                System.out.println("====success====");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("==========upload fail=====");
            }finally {
                fileInputStream.close();
                ftpClient.disconnect();
            }


        }
        return  false;
    }





}
