package com.allen.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(String id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id;
    }
    public String paymentInfo_TimeOut(String id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id;
    }
}
