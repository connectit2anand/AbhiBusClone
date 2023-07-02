package com.apnabus.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("adminService")
    public String defaultAdminServiceHandler() {
        return"Admin Service is currently down please try again later";
    }
}
