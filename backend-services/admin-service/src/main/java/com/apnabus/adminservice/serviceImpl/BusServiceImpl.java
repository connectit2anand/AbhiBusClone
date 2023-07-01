package com.apnabus.adminservice.serviceImpl;

import com.apnabus.adminservice.DTO.BusDTO;
import com.apnabus.adminservice.entity.Bus;
import com.apnabus.adminservice.entity.Route;
import com.apnabus.adminservice.exception.BusException;
import com.apnabus.adminservice.exception.InvalidRequestException;
import com.apnabus.adminservice.repository.BusRepository;
import com.apnabus.adminservice.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    @Override
    public String addBus(Bus bus) {

        String busNumber = bus.getBusNumber();
        List<Bus> buses = busRepository.findByBusNumber(busNumber);
        if(buses.size() != 0){
            throw new BusException("Bus Already Exist");
        }

        LocalDate journeDate = bus.getBusJourneyDate();
        if(journeDate.isBefore(LocalDate.now())){   //comparing journey date from current date
            throw new InvalidRequestException("Please Enter Valid Journey Date");
        }

        busRepository.save(bus);
        return "Bus Successfully Added";
    }

    @Override
    public String updateBus(BusDTO busDTO, Integer busId) {

        Bus bus = busRepository.findById(busId).orElseThrow(()->new BusException("Bus Id Does Not Exist"));

        if(busDTO.getDriverName() != null){
            bus.setDriverName(busDTO.getDriverName());
        }
        if(busDTO.getBusJourneyDate() != null){
            bus.setBusJourneyDate(busDTO.getBusJourneyDate());
        }
        if(busDTO.getFare() != null){
            bus.setFare(busDTO.getFare());
        }
        if(busDTO.getArrivalTime() != null){
            bus.setArrivalTime(busDTO.getArrivalTime());
        }
        if(busDTO.getDepartureTime() != null){
            bus.setDepartureTime(busDTO.getDepartureTime());
        }
        if(busDTO.getRoute() != null){
            bus.setRoute(busDTO.getRoute());
        }
        busRepository.save(bus);

        LocalDate journeDate = bus.getBusJourneyDate();
        if(journeDate.isBefore(LocalDate.now())){   //comparing journey date from current date
            throw new InvalidRequestException("Please Enter Valid Journey Date");
        }
        return "Bus Successfully Updated";
    }

    @Override
    public String deleteBus(Integer busId) {
        Bus bus = busRepository.findById(busId).orElseThrow(()-> new InvalidRequestException("Bus Id Not Valid"));
        bus.setActive(false);
        busRepository.save(bus);
        return "Bus Successfully Deleted";
    }

    @Override
    public List<Bus> getAllBus() {

        List<Bus> busList = busRepository.getAllBus();
        return busList;
    }
}
