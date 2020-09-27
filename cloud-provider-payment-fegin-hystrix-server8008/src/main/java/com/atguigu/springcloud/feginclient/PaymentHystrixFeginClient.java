package com.atguigu.springcloud.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component           //标记是一个组件
@FeignClient(value="payment-hystrix-server8003")      //标记是一个Fegin的接口value等于要调用的微服务名称
public interface PaymentHystrixFeginClient {

    @RequestMapping("/hystrix/paymentInfo_Ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Long id);

    @RequestMapping("/hystrix/paymentInfo_TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) throws InterruptedException ;
}
