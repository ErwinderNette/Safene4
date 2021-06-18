package com.example.demo.Repository;

import com.example.demo.Entity.Truck;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class TruckRepo {

    List<Truck> truckList = new ArrayList<>();
    int id = 0;
    int temp = 0;

    // Truck adding
    public String addTruck(int position){
        id++;
        Truck truck = new Truck(id);

    if(position >= truckList.size()) {
        position = truckList.size();
        temp = 3;
    }else{
        if(position != 0) {
            temp = 2;
        }else{
            temp = 1;
        }
    }

    // Autofill positions
switch (temp) {
    case 1:
        truck.setFrontId(0);
        truck.setLeader(true);
        truck.setSpeed(80);
        truckList.add(0, truck);
        break;
    case 2:
        truck.setFrontId(truckList.get(position-1).getId());
        truck.setBackId(truckList.get(position+1).getId());
        truck.setLeader(false);
        truck.setSpeed(80);
        truckList.add(position, truck);
        truckList.get(position-1).setBackId(truck.getId());
        break;
    case 3:
        if(!truckList.isEmpty()) {
            truck.setFrontId(truckList.get(position - 1).getId());
            truckList.get(position-1).setBackId(truck.getId());
        }
        truck.setBackId(0);
        truck.setLeader(false);
        truck.setSpeed(80);
        truckList.add(truck);
        break;
}
        return "Hat geklappt";
    }
        // Update Method
    public void update(){
        for(int i=1; i < truckList.size(); i++){
            if(truckList.get(i-1)!=null&&truckList.get(i-1).getId()!=truckList.get(i).getFrontId());{
                truckList.get(i).setFrontId(truckList.get(i-1).getId());
            }
            if(truckList.get(i+1)!=null&&truckList.get(i+1).getId()!=truckList.get(i).getBackId());{
                truckList.get(i).setBackId(truckList.get(i+1).getId());
            }
            truckList.get(i).setLeader(false);
        }
    }

    public Truck getTruckById(int id){
        Truck t = null;
        for (int i=0; id < truckList.size(); i++) {
            if(id == truckList.get(i).getId()){
                t = truckList.get(i);
                break;
            }
        }
        return t;
    }
    public Truck getOneTruckById(int id) {
        Truck t = null;
//        for (int i = 0; id < truckList.size(); i++) {

        t = truckList.get(id);
        return t;
    }

    public List<Truck> getTruckList() {
        return truckList;
            }

    public void setTruckList(List<Truck> truckList) {
        this.truckList = truckList;
    }


        }
