package com.allen.cloud.service;

import com.allen.cloud.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getById(Long id);
}
