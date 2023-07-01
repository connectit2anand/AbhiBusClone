package com.apnabus.adminservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="route_from")
    private String routeFrom;
    @Column(name="route_to")
    private String routeTo;
    private int distance;
    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Bus> busList;
}
