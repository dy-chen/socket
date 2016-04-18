package com.company.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Receive implements  Runnable{
    private Socket s;
    public Receive(Socket s){
        this.s=s;
    }
    public void run() {
        Scanner sc;
        try {
            sc = new  Scanner(s.getInputStream());
            String str=null;
            while (true){
                str=sc.nextLine();
                System.out.println(str);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
