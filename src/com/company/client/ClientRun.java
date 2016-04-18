package com.company.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by wangcy on 2016/4/18.
 */
public class ClientRun {
    public static void main(String[] args) {
        try {
            byte[]b={(byte) 127,0,0,1};
            InetAddress ia= InetAddress.getByAddress(b);
            Socket s=new Socket(ia,8888);
            PrintWriter pw= new PrintWriter(s.getOutputStream(),true);
            Thread t=new Thread(new Receive(s));
            t.start();
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                pw.println(sc.nextLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}