package com.apnabus.adminservice.service;

import com.apnabus.adminservice.DTO.BusDTO;
import com.apnabus.adminservice.entity.Bus;

import java.util.List;

public interface BusService {

    String addBus(Bus bus, Integer routeId);

    String updateBus(BusDTO busDTO, Integer busId);

    String deleteBus(Integer busId);

    List<Bus> getAllBus();
}
