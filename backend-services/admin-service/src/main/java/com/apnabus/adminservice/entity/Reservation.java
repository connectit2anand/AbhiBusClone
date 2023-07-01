package com.apnabus.adminservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    private LocalDate date;
    private LocalTime time;
    private String source;
    private String destination;
    @Column(name="journey_date")
    private LocalDate journeyDate;
    @Column(name="booked_date")
    private LocalDate bookedDate;
    @Column(name="booked_seat")
    private Integer bookedSeat;
    @Column(name="fare")
    private double fare;
    @ManyToOne
    private User user;
    @ManyToOne
    private Bus bus;

}
