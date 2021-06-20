package com.example.demo.Client;

import com.example.demo.Client.Socket.SocketClient;
import com.example.demo.Client.Socket.SocketServer;
import com.example.demo.Client.model.Truck;
import com.example.demo.Server.Controller.Controller;
import com.example.demo.Server.Repository.TruckRepo;

import java.io.IOException;

import static com.example.demo.Client.HTTPConec.register;

public class Start {


    private static Truck truck;
    private static SocketServer server;
    private static SocketClient front;
    private static SocketClient back;
//    private static SocketClient speed;
//    private static TruckRepo truckRepo;

    public static void main(String[] args) {


        try {
            truck = HTTPConec.register(10);

            if (truck.getFrontId() != 0)
            {
                front = new SocketClient(truck.getFrontId());
                front.sendMessage("Hello front truck");
                front.sendMessage("i bin hinter dir" + truck.getId()); // "Aktuelle Geschwindigkeit: "); //+ truck.getSpeed());
//                front.sendMessage("Aktuelle Geschwindigkeit: "+ truck.getSpeed());
            }
            if (truck.getBackId() != 0)
            {
                back = new SocketClient(truck.getBackId());
                back.sendMessage("Hello back truck");
                back.sendMessage("i bin vor dir" + truck.getId()); //"Aktuelle Geschwindigkeit: "); //+truck.getSpeed());
//                back.sendMessage("Aktuelle Geschwindigkeit: "+ truck.getSpeed());
            }
//            if (truck.getSpeed() != 0)
//            {
//                speed = new SocketClient(truck.setSpeed(speed));
//                speed.sendMessage("Geschwindigkeit changed");
//                speed.sendMessage("Aktuelle Geschwindigkeit: " + truck.getSpeed());
//            }
            server = new SocketServer(truck.getId());
            System.out.println(truck);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newSpeed(int speed){

        truck.setSpeed(speed);
    }

    public static void newFrontConec(int id){
        truck.setFrontId(id);
        front = new SocketClient(truck.getFrontId());
        front.sendMessage("Aktuelle Geschwindigkeit: " + truck.getSpeed());
    }

    public static void newBackConec(int id){
        truck.setBackId(id);
        back = new SocketClient(truck.getBackId());
        back.sendMessage("Aktuelle Geschwindigkeit: "+ truck.getSpeed());
    }


//        front = new SocketClient(truck.getSpeed());
//        front.sendMessage("Aktuelle Geschwindigkeit: " + truck.getSpeed());
}
