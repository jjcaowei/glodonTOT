package com.glodon.springcloud.service;

import com.glodon.springcloud.entities.Payment;


public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
