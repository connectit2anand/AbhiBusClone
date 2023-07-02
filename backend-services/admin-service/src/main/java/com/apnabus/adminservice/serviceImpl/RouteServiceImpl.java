package com.apnabus.adminservice.serviceImpl;

import com.apnabus.adminservice.entity.Bus;
import com.apnabus.adminservice.entity.Route;
import com.apnabus.adminservice.exception.RouteException;
import com.apnabus.adminservice.repository.RouteRepository;
import com.apnabus.adminservice.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;
    @Override
    public String addRoute(Route route) {

        route.setBusList(new ArrayList<>());
        routeRepository.save(route);
        return "Route Successfully Added";
    }

    @Override
    public String deleteRoute(Integer routeId) {
        Route route = routeRepository.findById(routeId).orElseThrow(()-> new RouteException("Route Does Not Exist"));
        route.setIsActive(false);
        routeRepository.save(route);
        return "Route Successfully Deleted";
    }
}
