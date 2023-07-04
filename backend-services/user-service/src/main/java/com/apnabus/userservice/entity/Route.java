package com.apnabus.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="route_from")
    private String routeFrom;
    @Column(name="route_to")
    private String routeTo;
    @Column(name="distance")
    private Integer distance;
    @Column(name="is_active")
    private Boolean isActive = true;
    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Bus> busList;
}
