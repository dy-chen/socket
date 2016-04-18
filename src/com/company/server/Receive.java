package com.company.server;

import com.company.server.Crudsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
class Receive implements  Runnable{
    private Socket s;
    public Receive(Socket s){
        this.s=s;
    }
    public void run() {
        PrintWriter pw;
        Scanner sc;
        try {
            Crudsd sd=new Crudsd();
            pw = new PrintWriter(s.getOutputStream(),true);
            pw.println("请输入你要进行的操作");
            pw.println("1,注册用户   2,删除用户");
            pw.println("3,修改用户   4,查询用户");
            pw.println("5,退出系统");
            sc = new  Scanner(s.getInputStream());
            String str=null;
            String currentStatus = "";
            while (true){
                str=sc.nextLine();
                if(str.equals("1")){
                    pw.println("请输入您的账号密码");
                    //pw.print(s);
                    //pw.println("注册成功!");
                    currentStatus = "create";
                }if(str.equals("2")){
                    pw.println("请输入您要删除的用户名");
                    /*sd.deleteUser();
                    pw.println("删除成功!");*/
                    currentStatus = "delete";
                }if(str.equals("3")){
                    pw.println("请输入您要更新的用户名");
                    /*sd.updateUser();
                    pw.println("更新成功!");*/
                    currentStatus = "update";
                }if(str.equals("4")){
                    currentStatus = "select";
                }if(str.equals("5")){
                    break;
                }

                if ("create".equals(currentStatus)){
                    sd.creatUser(sc);
                    pw.println("注册成功!");
                }else if ("delete".equals(currentStatus)){
                    sd.deleteUser(sc);
                    pw.println("删除成功!");
                }else if("update".equals(currentStatus)){
                    sd.updateUser(sc);
                    pw.println("更新成功!");
                }else if ("select".equals(currentStatus)){
                    sd.selectUser();
                }
            }
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
