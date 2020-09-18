package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entityes.Payment;

/**
 * description: PaymentService8002的service接口<br>
 * date: 2020/9/18 9:39 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
public interface PaymentService8002 {


        public Payment getpaymentById(Long id);

        public int create(Payment payment);

}
