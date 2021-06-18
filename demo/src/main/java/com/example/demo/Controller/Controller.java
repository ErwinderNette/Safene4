package com.example.demo.Controller;

import com.example.demo.Entity.Truck;
import com.example.demo.Service.TruckService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    Truck truck = new Truck(1,2,3,80,true);
    TruckService truckService = new TruckService();

//    @RequestMapping(path="/test")
//    public @ResponseBody Truck test(){
//        return truckService.getTruckById(2);
//    }

    @RequestMapping(path="/addTruck/{position}")
    public String addTruck(@PathVariable int position){
        truckService.addTruck(position);
        return "Ein neuer Truck ist dem Platoon beigetreten!";
    }

    @RequestMapping(path="/getPlatoon")
    public List<Truck> getPlatoon(){
        return truckService.getTruckList();
    }

    @RequestMapping(path ="/showTruckAgentById/{id}")
    public @ResponseBody Truck show(){
        return truckService.getOneTruckById(truck.getId());
    }

    @RequestMapping(path = "/stop/{id}")
    public @ResponseBody
    String stop(){return truckService.stop(truck.getId());}

    @RequestMapping(path ="/slowdown/{id}" )
    public @ResponseBody
    String slowdown(){return truckService.slowdown(truck.getId());}

    @RequestMapping(path = "/changeSpeed/{id}/{speed}")
    public String changeSpeed(@PathVariable int id, @PathVariable int speed){
        return truckService.changeSpeed(id, speed); }

    @RequestMapping(path = "/exit/{id}")
    public String exit(@PathVariable int id){

        return truckService.exitPlatoon(id);
    }
}
