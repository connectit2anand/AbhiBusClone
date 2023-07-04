package com.apnabus.userservice.repository;

import com.apnabus.userservice.entity.Bus;
import com.apnabus.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

}
