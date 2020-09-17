package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description: OrderController <br>
 * date: 2020/9/7 10:54 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController
public class OrderController {

    private final String URL = "http://localhost:8001/";
@Autowired
    private RestTemplate restTemplate;

@RequestMapping(value = "/consumer/payment/{id}")
    public CommonResult getpaymentById(@PathVariable("id") Long id){
   return  restTemplate.getForObject(URL + "/payment/get/" + id, CommonResult.class);
}
    @RequestMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return  restTemplate.postForObject(URL + "/payment/create/", payment, CommonResult.class);
    }
}
