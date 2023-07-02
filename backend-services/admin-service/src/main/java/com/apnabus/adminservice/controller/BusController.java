package com.apnabus.adminservice.controller;

import com.apnabus.adminservice.DTO.BusDTO;
import com.apnabus.adminservice.entity.Bus;
import com.apnabus.adminservice.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/bus/")
public class BusController {
    @Autowired
    BusService busService;

    @PostMapping("addBus")
    public ResponseEntity<String> addBus(@RequestBody Bus bus){
        String response = busService.addBus(bus);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("updateBus/{busId}")
    public ResponseEntity<String> updateBus(@RequestBody BusDTO busDTO,@PathVariable Integer busId){
        String response = busService.updateBus(busDTO,busId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("deleteBus/{busId}")
    public ResponseEntity<String> deleteBus(@PathVariable Integer busId){
        String response = busService.deleteBus(busId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("getAllBuses")
    public ResponseEntity<List<Bus>> getAllBuses(){
        List<Bus> busList  = busService.getAllBus();
        return new ResponseEntity<>(busList,HttpStatus.OK);
    }
}
