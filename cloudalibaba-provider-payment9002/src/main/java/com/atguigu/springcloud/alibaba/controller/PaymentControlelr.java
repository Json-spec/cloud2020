package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentControlelr {

    @Value("${server.port}")
    private String port;


    @RequestMapping(value="/index")
    public String getIdex(){
        return UUID.randomUUID().toString().replaceAll("-","")+" 服务端口号:"+port;
    }
}
