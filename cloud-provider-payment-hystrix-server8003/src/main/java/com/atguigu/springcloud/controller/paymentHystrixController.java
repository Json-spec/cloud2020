package com.atguigu.springcloud.controller;



import ch.qos.logback.core.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.springcloud.entityes.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class paymentHystrixController {

    @Autowired
    private com.atguigu.springcloud.server.paymentHystrixService paymentHystrixService;
@RequestMapping("/hystrix/paymentInfo_Ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Long id){
       Payment payment  =paymentHystrixService.selectByid(id);
        String result = JSONObject.toJSONString(payment);
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_Ok,id"+id ;
    }

    @RequestMapping("/hystrix/paymentInfo_TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) throws InterruptedException {
    /*Thread.sleep(300);*/
        int timeout = 3 ;
        TimeUnit.SECONDS.sleep(timeout);
        Payment payment  =paymentHystrixService.selectByid(id);
        String result = JSONObject.toJSONString(payment);
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id"+id;
    }

}
