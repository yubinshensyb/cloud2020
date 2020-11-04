package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
    
}
