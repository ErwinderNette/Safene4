package com.example.demo.Client.Socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class SocketClient {

    Socket s;
    public SocketClient(int id){
        int port = 9000 + id;

        try{
            s=new Socket("localhost",port);



        }catch(Exception e){System.out.println(e);}
    }



    public void sendMessage(String message)
    {
        try {
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(message);
            dout.flush();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

