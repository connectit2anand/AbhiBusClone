package com.apnabus.adminservice.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RouteDTO {

    private String routeFrom;
    private String routeTo;
    private Integer distance;
    private Boolean isActive = true;
}
