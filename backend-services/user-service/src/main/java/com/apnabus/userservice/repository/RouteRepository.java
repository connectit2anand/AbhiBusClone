package com.apnabus.userservice.repository;

import com.apnabus.userservice.entity.Bus;
import com.apnabus.userservice.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Bus,Integer> {
    @Query("select b from Route b where b.routeFrom =?1 and b.routeTo =?2")
    Route getRoute(String source, String destination);

    @Query("select distinct (r.routeFrom) from Route r")
    List<String> getAllSource();
    @Query("select distinct (r.routeTo) from Route r")
    List<String> getAllDestination();
}
