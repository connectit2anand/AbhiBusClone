package com.apnabus.adminservice.repository;

import com.apnabus.adminservice.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Integer> {
    List<Bus> findByBusNumber(String busNumber);

    @Query("select b from Bus b where b.isActive = true ")
    List<Bus> getAllBus();
}
