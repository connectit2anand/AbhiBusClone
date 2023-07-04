package com.apnabus.userservice.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDTO {
    private LocalDate journeyDate;
    private String routeFrom;
    private String routeTo;
}
