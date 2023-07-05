package com.apnabus.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private Bus bus;


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", journeyDate=" + journeyDate +
                ", bookedDate=" + bookedDate +
                ", bookedSeat=" + bookedSeat +
                ", fare=" + fare +
                '}';
    }
}
