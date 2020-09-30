package com.atguigu.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.server.HystrixTestServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
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

   //服务降级实例fallback
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
    //服務降級方法
    public String paymentInfoById_ok(Long id){
        return "系统服务异常，回调方法paymentInfoById_ok";
    }
    public String paymentInfoById_timeout(Long id){
        return "系统服务异常，回调方法paymentInfoById_timeout";
    }





    //服务熔断示例
    @RequestMapping("/hystrix/circuitBreaker/{id}")
    @HystrixCommand(fallbackMethod = "paymentHystrixRongduan_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),                          //是否开清断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),              //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),        //时间范围
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),           //失败率达到多少后跳闸
    })
    public String paymentHystrixRongduan(@PathVariable("id") Long id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String random = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"调用成功，服务的流水号是："+random;
    }

    public String paymentHystrixRongduan_fallback(@PathVariable("id")Long id){
        return "id不能为负数，请稍后再试id:"+id;
    }

}
