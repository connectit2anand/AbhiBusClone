package com.apnabus.adminservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="bus")
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message="Bus Name Cannot Be Null")
    @Column(name = "bus_name")
    private String busName;

    @NotNull(message="Bus Number Cannot Be Null")
    @Column(name="bus_number")
    private String busNumber;
    @NotNull(message="Driver Name Cannot Be Null")
    @Column(name = "driver_name")
    private String driverName;

    @NotNull(message="Bus Type Cannot Be Null")
    @Column(name = "bus_type")
    private String busType;

    private boolean isActive = true;

    @NotNull(message="Bus Journey Date Cannot Be Null")
    @Column(name = "bus_journey_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate busJourneyDate;

    @NotNull(message="Bus Journey Time Cannot Be Null")
    @Column(name = "bus_journey_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime arrivalTime;

    @NotNull(message="Bus Departure Time Cannot Be Null")
    @Column(name = "bus_departure_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime departureTime;

    @Column(name="total_seats")
    @NotNull(message = "Total Number Of Seats Cannot Be Null")
    private Integer totalSeats;

    @Column(name="available_seats")
    @NotNull(message="Availbale Seats Cannot Be Null")
    private Integer availabaleSeats;

    @Column(name = "fare")
    @NotNull(message="Fare Cannot Be Null")
    private Double fare;

    @ManyToOne
    private Route route;
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<Reservation> reservationList;
}
