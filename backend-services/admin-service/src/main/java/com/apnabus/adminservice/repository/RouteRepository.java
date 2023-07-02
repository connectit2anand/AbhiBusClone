package com.apnabus.adminservice.repository;

import com.apnabus.adminservice.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Integer> {

    @Query("select r from Route r where r.isActive = true")
    List<Route> getAllRoute();

    @Query("select r from Route r where r.isActive = true and r.routeFrom=?1  and r.routeTo=?2")
    Route getRouteByRouteFromAndRouteTo(String routeFrom,String routeTo);
}
