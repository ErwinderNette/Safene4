package com.example.demo.Client.Socket;

import com.example.demo.Client.Start;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class SocketServer {

    ServerSocket ss;
    Socket s;
    public SocketServer(int id) {
        int port = 9000+ id;
        try
        {
            ss = new ServerSocket(port);

            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            try {
                                s = ss.accept();
                                DataInputStream din=new DataInputStream(s.getInputStream());

                                    String message = din.readUTF();
                                    if (message.contains("i bin hinter dir"))
                                    {
                                        String id = message.substring(16);
                                        Start.newBackConec(Integer.parseInt(id));
                                    }

                                    else if (message.contains("i bin vor dir"))
                                    {
                                        String id = message.substring(13);
                                        Start.newFrontConec(Integer.parseInt(id));
                                    }

                                    else if (message.contains("Aktuelle Geschwindigkeit: ")){
                                        int speed = Integer.parseInt(message.substring(26));
                                        Start.newSpeed(Integer.parseInt(String.valueOf(speed)));
                                    }
                                    System.out.println("client says: "+message);


                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        }
                    }, 10,1000
            );

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}

