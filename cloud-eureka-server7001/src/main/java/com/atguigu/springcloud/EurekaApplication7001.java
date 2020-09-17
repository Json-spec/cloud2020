package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description: EurekaApplication7001 <br>
 * date: 2020/9/9 17:53 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication                             //springBoot的主启动注解是一个复合注解包括（SpringBootConfiguration , EnableAutoConfiguration,ComponentScan）三个主要注解
@EnableEurekaServer                               //启动eureka注册中心的服务端标记此服务是注册中心服务端后续服务客户端会像此注册中心服务端注册
public class EurekaApplication7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7001.class,args);
    }
}
