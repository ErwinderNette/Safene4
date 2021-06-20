package com.example.demo.Server.Service;

import com.example.demo.Server.Entity.Truck;
import com.example.demo.Server.Repository.TruckRepo;

import java.util.List;

public class TruckService {

    TruckRepo truckRepo = new TruckRepo();


    public Truck addTruck(int position){
        return truckRepo.addTruck(position);
    }

    public List<Truck> getTruckList() {
        return truckRepo.getTruckList();
    }

    // Geschwindigkeit ändern
    public String changeSpeed(int id, int speed){
        truckRepo.getTruckById(id).setSpeed(speed);
        return "Geschwindigkeit auf "
                + truckRepo.getTruckById(id).getSpeed()
                + " geändert ! Mit Eingaebe: "
                + speed;
    }

    // Bremsen
    public String slowdown(int id){
        int speed=80;
        truckRepo.getOneTruckById(id).setSpeed(speed-10);
        return "Truck mit der ID "+id +" hat die Geschwidigkeit auf "+ truckRepo.getOneTruckById(id).getSpeed()+" geändert";
    }

    // Truck stoppen
    public String stop(int id){
        truckRepo.getOneTruckById(id).setSpeed(0);
        return "Truck mit der ID "+id+ " ist gestoppt";
    }

    // Exit Platoon
    public String exitPlatoon(int id){
        truckRepo.getTruckList().remove(id);
        id++;
        return "Truck mit der ID "+id+ " hat den Platoon verlassen";
    }

    // Auswahl aller Trucks über ID
    public Truck getTruckById(int id){
        return truckRepo.getTruckById(id);
    }

    // Auswahl von einem Truck über ID
    public Truck getOneTruckById(int id) {
        return truckRepo.getOneTruckById(id);
    }
}
