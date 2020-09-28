package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: HystrixApplication900 <br>
 * date: 2020/9/28 17:14 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
//此模块是为了单纯测试Hytrix的熔断机制为整合任何技术，在hystrix和openfegin一起使用的情况下回调的方法就没有通常会使用@FeginClient中的fallbackFactory属性进行指定一个fallbackFactory<T>工厂接口形式
//具体项目中这种单纯的方式需要避免一般都是和openfegin一起使用的   具体使用实例请参照 cloud-provider-payment-fegin-hysreix-server8080模块
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker()
public class HystrixApplication900 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication900.class,args);
    }
}
