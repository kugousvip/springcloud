package com.allen.cloud.controller;

import com.allen.cloud.entity.CommonResult;
import com.allen.cloud.entity.Payment;
import com.allen.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String servicePort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入结果："+result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,服务端口："+servicePort,result);
        }else {
            return new CommonResult(400,"插入失败,服务端口："+servicePort);
        }
    }
    @GetMapping(value = "/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        Payment result = paymentService.getById(id);
        log.info("*******查询结果："+result);
        if (result != null){
            return new CommonResult(200,"查询成功,服务端口："+servicePort,result);
        }else {
            return new CommonResult(400,"查询失败，Id:"+id+",服务端口："+servicePort);
        }
    }
    @GetMapping(value = "getPort")
    public String getPort(){
        return servicePort;
    }
}
