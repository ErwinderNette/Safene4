package com.example.demo.Server.Controller;

import com.example.demo.Server.Entity.Truck;
import com.example.demo.Server.Service.TruckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    Truck truck = new Truck(1,2,3,80,true);
    TruckService truckService = new TruckService();

//    @RequestMapping(path="/test")
//    public @ResponseBody Truck test(){
//        return truckService.getTruckById(2);
//    }

    @GetMapping(path="/addTruck/{position}")
    public @ResponseBody Truck addTruck(@PathVariable int position){

        return  truckService.addTruck(position);
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
