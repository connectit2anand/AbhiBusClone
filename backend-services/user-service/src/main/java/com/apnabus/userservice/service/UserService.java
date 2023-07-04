package com.apnabus.userservice.service;

import com.apnabus.userservice.DTO.UserDTO;
import com.apnabus.userservice.entity.Bus;

import java.util.List;

public interface UserService {
    List<Bus> busList(UserDTO userDTO);
}
