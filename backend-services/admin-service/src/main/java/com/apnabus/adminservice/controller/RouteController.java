package com.apnabus.adminservice.controller;

import com.apnabus.adminservice.DTO.RouteDTO;
import com.apnabus.adminservice.entity.Route;
import com.apnabus.adminservice.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/routes/")
public class RouteController {
    @Autowired
    RouteService routeService;
    @PostMapping("addRoute")
    public ResponseEntity<String> addRoute(@RequestBody Route route){
        String response = routeService.addRoute(route);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("deleteRoute/{routeId}")
    public ResponseEntity<String> deleteRoute(@RequestBody Integer routeId){
        String response = routeService.deleteRoute(routeId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("updateRoute/{routeId}")
    public ResponseEntity<String> updateRoute(@RequestBody RouteDTO routeDTO,@PathVariable Integer routeId){
        String response = routeService.updateRoute(routeDTO,routeId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("getAllRoute")
    public ResponseEntity<List<Route>> getAllRoute(){
        List<Route> response = routeService.getAllRoute();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
