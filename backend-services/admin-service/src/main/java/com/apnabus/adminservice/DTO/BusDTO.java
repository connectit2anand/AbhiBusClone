package com.apnabus.adminservice.DTO;

import com.apnabus.adminservice.entity.Route;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class BusDTO {

    private String driverName;
    private LocalDate busJourneyDate;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private Double fare;

}
