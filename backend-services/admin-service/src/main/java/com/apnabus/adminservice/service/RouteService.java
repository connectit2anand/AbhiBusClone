package com.apnabus.adminservice.service;

import com.apnabus.adminservice.DTO.RouteDTO;
import com.apnabus.adminservice.entity.Route;

import java.util.List;

public interface RouteService {
    String addRoute(Route route);

    String deleteRoute(Integer routeId);

    String updateRoute(RouteDTO routeDTO, Integer routeId);

    List<Route> getAllRoute();
}
