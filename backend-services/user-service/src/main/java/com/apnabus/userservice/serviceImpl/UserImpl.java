package com.apnabus.userservice.serviceImpl;

import com.apnabus.userservice.DTO.UserDTO;
import com.apnabus.userservice.entity.Bus;
import com.apnabus.userservice.entity.Route;
import com.apnabus.userservice.repository.RouteRepository;
import com.apnabus.userservice.repository.UserRepository;
import com.apnabus.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RouteRepository routeRepository;
    @Override
    public List<Bus> busList(UserDTO userDTO) {
        String source = userDTO.getRouteFrom().toUpperCase();
        String destination = userDTO.getRouteTo().toUpperCase();
        LocalDate dateOfJourney = userDTO.getJourneyDate();
        //Getting Route
        Route route= routeRepository.getRoute(source,destination);
        //Getting list of Bus from the route
        List<Bus> listOfBus = route.getBusList();
        //Selecting the required bus list as per the required journey date
        List<Bus> finalBusList = new ArrayList<>();
        for(Bus bus : listOfBus){
            if(bus.getBusJourneyDate().equals(dateOfJourney)){
                finalBusList.add(bus);
            }
        }
        return finalBusList;
    }

    @Override
    public Map<String, List<String>> listOfSourceAndDestination() {

        List<String> sourceList = routeRepository.getAllSource();
        List<String> destinationList = routeRepository.getAllDestination();
        Map<String,List<String>> hm = new HashMap<>();
        hm.put("source",sourceList);
        hm.put("destination",destinationList);
        return hm;
    }
}
