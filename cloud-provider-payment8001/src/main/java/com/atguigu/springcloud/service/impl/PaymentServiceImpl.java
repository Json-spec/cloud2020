package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: PaymentServiceImpl <br>
 * date: 2020/9/7 10:20 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;


    public Payment getpaymentById(Long id) {
        return paymentMapper.getpaymentById(id);
    }

    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }
}
