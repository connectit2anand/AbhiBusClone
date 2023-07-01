package com.apnabus.adminservice.service;

import com.apnabus.adminservice.DTO.BusDTO;
import com.apnabus.adminservice.entity.Bus;

public interface BusService {

    String addBus(Bus bus);

    String updateBus(BusDTO busDTO, Integer busId);

    String deleteBus(Integer busId);
}
