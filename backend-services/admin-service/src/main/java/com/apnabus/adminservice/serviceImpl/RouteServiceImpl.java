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

        String routeFrom = route.getRouteFrom().toUpperCase();
        String routeTo = route.getRouteTo().toUpperCase();
        validateRoutes(routeFrom, routeTo);
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

    private void validateRoutes(String routeFromDto, String routeToDto) {
        if(routeFromDto.equals(routeToDto)) {
            throw new RouteException("Route From And Route To Cannot Be Same");
        }
        Route r = routeRepository.getRouteByRouteFromAndRouteTo(routeFromDto, routeToDto);
        if(r != null) {
            throw new RouteException("Route From and Route to already exists");
        }
    }

    @Override
    public String updateRoute(RouteDTO routeDTO, Integer routeId) {

        Route route = routeRepository.findById(routeId).orElseThrow(()-> new RouteException("Invalid Routde Id"));
        String routeFromDto = routeDTO.getRouteFrom().toUpperCase();
        String routeToDto = routeDTO.getRouteTo().toUpperCase();
        String routeFromDb = route.getRouteFrom();
        String routeToDb = route.getRouteTo();

        if(routeFromDto != null && routeToDto != null) {
           validateRoutes(routeFromDto, routeToDto);
        } else if(routeFromDto != null || routeToDto != null) {
            validateDifferentRoutes(routeFromDto, routeToDto, routeFromDb, routeToDb);
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
        routeRepository.save(route);
        return "Route Successfully Updated";
    }

    private void validateDifferentRoutes(String routeFromDto, String routeToDto, String routeFromDb, String routeToDb) {
        if(routeFromDto != null && routeFromDto.equals(routeToDb)){
            throw new RouteException("Route From And Route To Cannot Be Same");
        }
        if(routeToDto != null &&  routeToDto.equals(routeFromDb)){
            throw new RouteException("Route From And Route To Cannot Be Same");
        }
    }

    @Override
    public List<Route> getAllRoute() {
        return routeRepository.getAllRoute();
    }
}
