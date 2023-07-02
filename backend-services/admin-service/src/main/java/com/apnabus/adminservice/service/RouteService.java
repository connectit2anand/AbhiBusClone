package com.apnabus.adminservice.service;

import com.apnabus.adminservice.entity.Route;

public interface RouteService {
    String addRoute(Route route);

    String deleteRoute(Integer routeId);
}
