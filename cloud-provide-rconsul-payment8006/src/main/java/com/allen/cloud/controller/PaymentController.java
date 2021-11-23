package com.allen.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String servicePort;

    @GetMapping(value = "/consul")
    public String zookeeper(){
        return new StringBuilder("SpringCloud with consul:")
                .append(servicePort).append(",").append(UUID.randomUUID().toString()).toString();
    }
}
