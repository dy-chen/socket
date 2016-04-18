package com.company.server;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wangcy on 2016/4/18.
 */
public class Crudsd {
    public static void creatUser(Scanner sc){
        File f = new File("e:/User.txt");
        try {
            OutputStream os = new FileOutputStream(f,true);
            PrintStream ps = new PrintStream(os);
            //Scanner sc = new Scanner(System.in);
            Properties pps = new Properties();
            String key = sc.nextLine();
            String value=sc.nextLine();
            pps.setProperty(key, value);
            pps.list(ps);
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //删除
    public static void deleteUser(Scanner sc){
        File f = new File("e:/User.txt");
        try {
            InputStream is = new FileInputStream(f);
            Properties pps = new Properties();
            pps.load(is);
            //Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            pps.remove(s);
            OutputStream os = new FileOutputStream(f);
            PrintStream ps = new PrintStream(os);
            pps.list(ps);
            is.close();
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //修改
    public  static void updateUser(Scanner sc){
        File f = new File("e:/User.txt");
        InputStream is;
        try {
            is = new FileInputStream(f);
            Properties pps = new Properties();
            pps.load(is);
            //Scanner sc = new Scanner(System.in);
            String key = sc.nextLine();
            System.out.println("请输入您新的密码：");
            String value= sc.nextLine();
            pps.remove(key);
            pps.setProperty(key, value);
            OutputStream os = new FileOutputStream(f);
            PrintStream ps = new PrintStream(os);
            pps.list(ps);
            is.close();
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //查询
    public static void selectUser(){
        File f = new File("e:/User.txt");
        try {
            InputStream is =new FileInputStream(f);
            Properties pps = new Properties();
            pps.load(is);
            Set<String> s= pps.stringPropertyNames();
            Iterator<String> i = s.iterator();
            while(i.hasNext()){
                System.out.println(i.next().toString());
                String a=i.next();
//					return a;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        while(true){
            System.out.println("请输入你要进行的操作");
            System.out.println("1,注册用户   2,删除用户");
            System.out.println("3,修改用户   4,查询用户");
            System.out.println("5,退出系统");
            Scanner sc= new Scanner(System.in);
            int i = sc.nextInt();
            if(i==1){
                System.out.println("请输入您的账号密码");
                creatUser(sc);
                System.out.println("注册成功!");
            }if(i==2){
                System.out.println("请输入您要删除的用户名");
                deleteUser(sc);
                System.out.println("删除成功!");
            }if(i==3){
                System.out.println("请输入您要更新的用户名");
                updateUser(sc);
                System.out.println("更新成功!");
            }if(i==4){
                selectUser();
            }if(i==5){
                break;
            }
        }
    }
}
