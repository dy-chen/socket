package com.company.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangcy on 2016/4/18.
 */
public class ServerRun {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(8888);
            Socket s=ss.accept();
            Thread t=new Thread(new Receive(s));
            t.start();
//			Scanner sc=new Scanner(System.in);
//			while(sc.hasNext()){
//				pw.println(sc.nextLine());
//			}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
