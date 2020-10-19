package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * description: PaymentController <br>
 * date: 2020/10/19 14:10 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/index")
    public String getNacosPort(){
        return UUID.randomUUID().toString().replaceAll("-","")+"服务端口号:"+port;
    }
}
