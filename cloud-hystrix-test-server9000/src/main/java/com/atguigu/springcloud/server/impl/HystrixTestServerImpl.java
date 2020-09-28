package com.atguigu.springcloud.server.impl;

import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.mapper.PaymentTestMapper;
import com.atguigu.springcloud.server.HystrixTestServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: HystrixServerImpl <br>
 * date: 2020/9/28 17:23 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Service
public class HystrixTestServerImpl implements HystrixTestServer {

    @Autowired
    private PaymentTestMapper paymentTestMapper;

    @Override
    public Payment selectByid(Long id) {
        return paymentTestMapper.selectByid(id);
    }

    @Override
    public Payment selectById(Long id) {
        return paymentTestMapper.selectById(id);
    }


}
