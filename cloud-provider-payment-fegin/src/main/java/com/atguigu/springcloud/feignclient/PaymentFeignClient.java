package com.atguigu.springcloud.feignclient;

import com.atguigu.springcloud.entityes.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: PaymentFeignClient <br>
 * date: 2020/9/26 13:00 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Component
@FeignClient("cloud-payment-service")       //FeginClient注解value表示要调用的微服务名称
public interface PaymentFeignClient {              //openfegin中的接口方法要和服务提供者controller层要保持一致严格一致

    @RequestMapping("/payment/get/{id}")           //请求地址
    public com.atguigu.springcloud.entity.CommonResult getpaymentById(@PathVariable("id") Long id);        //此接口方法和服务提供者的controller层的方法要一样请求地址也要一样

    @RequestMapping("/payment/create")          //请求地址
    public com.atguigu.springcloud.entity.CommonResult create(@RequestBody Payment payment);
}
