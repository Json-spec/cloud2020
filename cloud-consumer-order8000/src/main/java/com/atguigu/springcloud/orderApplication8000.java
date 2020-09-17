package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: orderApplication8000 <br>
 * date: 2020/9/7 10:53 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication                        //springBoot的主启动注解是一个复合注解包括（SpringBootConfiguration , EnableAutoConfiguration,ComponentScan）三个主要注解
@EnableDiscoveryClient                        //开启注册中心客户端的服务发现（注解:可以支持eureka、zookeeper、nocas注册中心） @EnableEurekaClient 此注解只支持eureka的注册中心 项目中通常使用@EnableDiscoveryClient
public class orderApplication8000 {
    public static void main(String[] args) {
        SpringApplication.run(orderApplication8000.class,args);
    }
}
