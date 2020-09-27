package com.atguigu.springcloud.server;

import com.atguigu.springcloud.entityes.Payment;

public interface paymentHystrixService {
    Payment selectByid(Long id);
}
