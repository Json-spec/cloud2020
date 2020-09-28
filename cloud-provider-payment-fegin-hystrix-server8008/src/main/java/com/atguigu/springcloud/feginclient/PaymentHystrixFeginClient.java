package com.atguigu.springcloud.feginclient;

import com.atguigu.springcloud.feginclient.impl.PaymentHystrixFeginClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component           //标记是一个组件
@FeignClient(value="payment-hystrix-server8003" , fallbackFactory = PaymentHystrixFeginClientImpl.class )      //标记是一个Fegin的接口(定义fegin客户端)value等于要调用的微服务名称  fallbackFactory是系统异常所提示的实现类
//系统异常容错处理的两种方式:
// fallback：指定openFegin接口的实现类，实现接口的方法进行容错处理提示
//fallbackfactory： 指定一个实现FallbackFactory<T>工厂接口类 通过实现create方法在通过匿名内部类进行重写openFegin接口的方法可实现容错消息提示。

public interface PaymentHystrixFeginClient {

    @RequestMapping("/hystrix/paymentInfo_Ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Long id);

    @RequestMapping("/hystrix/paymentInfo_TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) throws InterruptedException ;
}
