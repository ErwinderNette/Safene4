package com.example.demo.Server.Repository;

import com.example.demo.Server.Entity.Truck;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class TruckRepo {

    List<Truck> truckList = new ArrayList<>();
    int id = 0;

    // Truck adding
    public Truck addTruck(int position){
        id++;
        Truck truck;

        if(position > truckList.size()) {
            position = truckList.size();
        }

        if (truckList.isEmpty())
        {
            //Erster überhaupt im Platoon
            truck = new Truck(id, 0, 0, 80, true);
            truckList.add(0, truck);
        }
        else if(position == truckList.size())
        {
            //Letzter im Platoon
            truck = new Truck(id, truckList.get(position - 1).getId(),0,80,false);
            truckList.add(position, truck);
            truckList.get(position-1).setBackId(id);
        }
        else if(position == 0)
        {
            // Einer Neuer will auf Leader
            truck = new Truck(id, 0,truckList.get(position).getId(), 80, true);
            truckList.add(0, truck);
            truckList.get(position +1).setFrontId(id);
            truckList.get(position+1).setLeader(false);

        }
        else
        {
            // Truck neu mittendrin
            truck = new Truck(id,truckList.get(position-1).getId(),truckList.get(position).getId(),80,false);
            truckList.add(position, truck);
            truckList.get(position-1).setBackId(id);
            truckList.get(position+1).setFrontId(id);
        }
        return truck;
    }

        // Update Method
//    public void update(){
//        for(int i=1; i < truckList.size(); i++){
//            if(truckList.get(i-1)!=null&&truckList.get(i-1).getId()!=truckList.get(i).getFrontId());{
//                truckList.get(i).setFrontId(truckList.get(i-1).getId());
//            }
//            if(truckList.get(i+1)!=null&&truckList.get(i+1).getId()!=truckList.get(i).getBackId());{
//                truckList.get(i).setBackId(truckList.get(i+1).getId());
//            }
//            truckList.get(i).setLeader(false);
//        }
//    }

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
