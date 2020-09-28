package com.atguigu.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.server.HystrixTestServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * description: HystrixTestController <br>
 * date: 2020/9/28 17:22 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController
public class HystrixTestController {

    @Autowired
    private HystrixTestServer hystrixServer;
    @RequestMapping("/hystrix/paymentInfo_Ok/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoById_ok")
    public String paymentInfo_Ok(@PathVariable("id") Long id){
        Payment payment  =hystrixServer.selectByid(id);
        int i = 10/0;
        String result = JSONObject.toJSONString(payment);
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_Ok,id"+id ;
    }

    @RequestMapping("/hystrix/paymentInfo_TimeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoById_timeout")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) throws InterruptedException {
        /*Thread.sleep(300);*/
        int timeout = 10 ;
        TimeUnit.SECONDS.sleep(timeout);
        Payment payment  =hystrixServer.selectById(id);
        String result = JSONObject.toJSONString(payment);
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id"+id;
    }
    public String paymentInfoById_ok(Long id){
        return "系统服务异常，回调方法paymentInfoById_ok";
    }
    public String paymentInfoById_timeout(Long id){
        return "系统服务异常，回调方法paymentInfoById_timeout";
    }
}
