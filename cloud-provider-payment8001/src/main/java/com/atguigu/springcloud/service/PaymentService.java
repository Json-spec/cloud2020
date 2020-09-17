package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entityes.Payment;

/**
 * description: PaymentService <br>
 * date: 2020/9/7 10:18 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
public interface PaymentService {

    public Payment getpaymentById(Long id);

    public int create(Payment payment);
}
