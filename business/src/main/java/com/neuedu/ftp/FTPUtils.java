package com.neuedu.ftp;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.util.List;

public class FTPUtils {


    private static  final  String FTPIP="47.94.155.74";
    private static  final  String FTPUSER="newuser";
    private static  final  String FTPPASSWORD="Qinfo20180507@";


    private  String  ftpIp;
    private  String  ftpUser;
    private  String  ftpPass;
    private  Integer port;

    public FTPUtils(String ftpIp, String ftpUser, String ftpPass, Integer port) {
        this.ftpIp = ftpIp;
        this.ftpUser = ftpUser;
        this.ftpPass = ftpPass;
        this.port = port;
    }


    /**
     * ͼƬ�ϴ���FTP
     * */

    public  static  boolean uploadFile(List<File> fileList) throws IOException {

        FTPUtils ftpUtil=new FTPUtils(FTPIP,FTPUSER,FTPPASSWORD,21);

        System.out.println("��ʼ����FTP������...");

        ftpUtil.uploadFile("img",fileList);

        return false;
    }


    public  boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        FileInputStream fileInputStream=null;
        //����ftp������
        if(connectFTPServer(ftpIp,ftpUser,ftpPass)){

            try {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();//�򿪱�������ģʽ
                for(File file:fileList){
                    fileInputStream=new FileInputStream(file);
                    ftpClient.storeFile(file.getName(),fileInputStream);
                }
                System.out.println("====�ļ��ϴ��ɹ�====");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("�ļ��ϴ�����...");
            }finally {
                fileInputStream.close();
                ftpClient.disconnect();
            }


        }
        return  false;
    }


    /**
     * ����ftp������
     * */
    FTPClient ftpClient=null;

    public    boolean connectFTPServer(String ip,String user,String password) {
        ftpClient=new FTPClient();

        try {
            ftpClient.connect(ip);
            return  ftpClient.login(user,password);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("����FTP�������쳣...");
        }
        return false;

    }


    public String getFtpIp() {
        return ftpIp;
    }

    public void setFtpIp(String ftpIp) {
        this.ftpIp = ftpIp;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPass() {
        return ftpPass;
    }

    public void setFtpPass(String ftpPass) {
        this.ftpPass = ftpPass;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}
