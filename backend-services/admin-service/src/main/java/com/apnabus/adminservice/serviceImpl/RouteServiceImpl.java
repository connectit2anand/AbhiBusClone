package com.apnabus.adminservice.serviceImpl;

import com.apnabus.adminservice.DTO.RouteDTO;
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

        String routeFrom = route.getRouteTo().toUpperCase();
        String routeTo = route.getRouteTo().toUpperCase();
        if(routeFrom.equals(routeTo)){
            throw new RouteException("Route From And Route To Cannot Be Same");
        }
        Route existingRoute = routeRepository.getRouteByRouteFromAndRouteTo(routeFrom,routeTo);
        if(existingRoute != null){
            throw new RouteException("Route Already Exist");
        }
        route.setRouteFrom(routeFrom);
        route.setRouteTo(routeTo);
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

    @Override
    public String updateRoute(RouteDTO routeDTO, Integer routeId) {

        Route route = routeRepository.findById(routeId).orElseThrow(()-> new RouteException("Invalid Routde Id"));
        String routeFromDto = routeDTO.getRouteFrom().toUpperCase();
        String routeToDto = routeDTO.getRouteTo().toUpperCase();
        String routeFromDb = route.getRouteFrom();
        String routeToDb = route.getRouteTo();

        if(routeFromDto != null && routeToDto == null && routeFromDto.equals(routeFromDb)){
            throw new RouteException("Route From And Route To Cannot Be Same");
        }
        if(routeToDto != null && routeFromDto == null && routeToDto.equals(routeToDb)){
            throw new RouteException("Route From And Route To Cannot Be Same");
        }

        if(routeFromDto != null && routeToDto != null && routeFromDto.equals(routeToDto)){
            throw new RouteException("Please Add Valid Route From And Route To Details");
        }
        if(routeDTO.getIsActive() != null){
            route.setIsActive(true);
        }
        if(routeDTO.getRouteFrom() != null){
            route.setRouteFrom(routeDTO.getRouteFrom());
        }
        if(routeDTO.getRouteTo() != null){
            route.setRouteTo(routeDTO.getRouteTo());
        }
        if(routeDTO.getDistance() != null){
            route.setDistance(routeDTO.getDistance());
        }

        //Route To And Route From Should Not Be Same
        String routeTo = route.getRouteTo();
        String routeFrom = route.getRouteFrom();
        if(routeTo.equalsIgnoreCase(routeFrom)){
            throw new RouteException("RouteTo And Route From Cannnot Be Same");
        }
        return "Route Successfully Updated";
    }

    @Override
    public List<Route> getAllRoute() {
        List<Route> routeList = routeRepository.getAllRoute();
        return routeList;
    }
}
