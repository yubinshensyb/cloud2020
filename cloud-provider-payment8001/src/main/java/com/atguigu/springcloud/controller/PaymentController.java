package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    Integer port;


    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){

        try {
            int i = paymentService.create(payment);
            log.debug("*****插入结果："+i);
            if (i==1){
                return new CommonResult<>(200,"插入payment成功,port="+port,payment);
            }else {
                return new CommonResult<>(444,"插入payment失败");
             }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(9999,"插入payment失败"+e.getMessage());
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        try {
            Payment payment = paymentService.getPaymentById(id);
            log.debug("*****查询结果："+payment);
            if (payment==null){
                return new CommonResult(444,"没有对应记录，查询ID："+id);
            }else {
                return new CommonResult(200,"查询成功,port="+port,payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(9999,"查询payment失败"+e.getMessage());

        }
    }


}
