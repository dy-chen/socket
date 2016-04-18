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
    //ɾ��
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
    //�޸�
    public  static void updateUser(Scanner sc){
        File f = new File("e:/User.txt");
        InputStream is;
        try {
            is = new FileInputStream(f);
            Properties pps = new Properties();
            pps.load(is);
            //Scanner sc = new Scanner(System.in);
            String key = sc.nextLine();
            System.out.println("���������µ����룺");
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
    //��ѯ
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
            System.out.println("��������Ҫ���еĲ���");
            System.out.println("1,ע���û�   2,ɾ���û�");
            System.out.println("3,�޸��û�   4,��ѯ�û�");
            System.out.println("5,�˳�ϵͳ");
            Scanner sc= new Scanner(System.in);
            int i = sc.nextInt();
            if(i==1){
                System.out.println("�����������˺�����");
                creatUser(sc);
                System.out.println("ע��ɹ�!");
            }if(i==2){
                System.out.println("��������Ҫɾ�����û���");
                deleteUser(sc);
                System.out.println("ɾ���ɹ�!");
            }if(i==3){
                System.out.println("��������Ҫ���µ��û���");
                updateUser(sc);
                System.out.println("���³ɹ�!");
            }if(i==4){
                selectUser();
            }if(i==5){
                break;
            }
        }
    }
}
