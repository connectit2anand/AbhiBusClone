package com.apnabus.userservice.service;

import com.apnabus.userservice.DTO.UserDTO;
import com.apnabus.userservice.entity.Bus;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Bus> busList(UserDTO userDTO);

    Map<String, List<String>> listOfSourceAndDestination();
}
