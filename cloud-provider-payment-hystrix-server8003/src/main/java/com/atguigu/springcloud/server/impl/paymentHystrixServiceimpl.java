package com.atguigu.springcloud.server.impl;

import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.mapper.paymentHystrixMapper;
import com.atguigu.springcloud.server.paymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class paymentHystrixServiceimpl implements paymentHystrixService {
    @Autowired
    private com.atguigu.springcloud.mapper.paymentHystrixMapper paymentHystrixMapper;
    public Payment selectByid(Long id) {
        return paymentHystrixMapper.selectById(id);
    }
}
