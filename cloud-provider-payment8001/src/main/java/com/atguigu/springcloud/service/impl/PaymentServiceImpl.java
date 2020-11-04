package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl  implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        int i = paymentDao.create(payment);
         return i;
    }

    @Transactional(timeout = 3,readOnly = true)
    @Override
    public Payment getPaymentById(Long id) {
        Payment paymetnById = paymentDao.getPaymentById(id);
        return paymetnById;
    }
}
