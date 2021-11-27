package com.allen.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String servicePort;

    @GetMapping(value = "/zookeeper")
    public String zookeeper(){
       return new StringBuilder("SpringCloud with zookeeper:")
               .append(servicePort).append(",").append(UUID.randomUUID().toString()).toString();
    }
}
