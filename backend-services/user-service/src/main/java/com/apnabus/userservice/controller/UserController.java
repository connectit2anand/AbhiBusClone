package com.apnabus.userservice.controller;

import com.apnabus.userservice.DTO.UserDTO;
import com.apnabus.userservice.entity.Bus;
import com.apnabus.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1.0/user/")
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping("getBusList")
    public ResponseEntity<List<Bus>> getBusList(@RequestBody UserDTO userDTO){
        List<Bus> response = userService.busList(userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("listOfSourceAndDestionation")
    public ResponseEntity<Map<String,List<String>>> listOfSourceAndDestination(){
        Map<String,List<String>> response = userService.listOfSourceAndDestination();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
