package com.apnabus.adminservice.controller;

import com.apnabus.adminservice.entity.Route;
import com.apnabus.adminservice.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
