package com.allen.cloud.controller;

import com.allen.cloud.entity.CommonResult;
import com.allen.cloud.entity.Payment;
import com.allen.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;

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
    @GetMapping(value = "discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***payment"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.error("*****instances"+instance.getInstanceId() +","+instance.getHost()
                    +","+instance.getPort()+","+instance.getUri());
        }
        return discoveryClient;
    }
}