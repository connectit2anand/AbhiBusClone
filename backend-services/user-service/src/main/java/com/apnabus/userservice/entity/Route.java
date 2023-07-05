package com.apnabus.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Bus> busList;

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", routeFrom='" + routeFrom + '\'' +
                ", routeTo='" + routeTo + '\'' +
                ", distance=" + distance +
                ", isActive=" + isActive +
                '}';
    }
}
