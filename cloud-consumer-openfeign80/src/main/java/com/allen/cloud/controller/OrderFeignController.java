package com.allen.cloud.controller;

import com.allen.cloud.entity.CommonResult;
import com.allen.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }
}
