package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication//springBoot的主启动注解是一个复合注解包括（SpringBootConfiguration , EnableAutoConfiguration,ComponentScan）三个主要注解
@EnableDiscoveryClient//开启注册中心客户端的服务发现（注解:可以支持eureka、zookeeper、nocas注册中心） @EnableEurekaClient 此注解只支持eureka的注册中心 项目中通常使用@EnableDiscoveryClient
public class ProviderForConsulApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderForConsulApplication8006.class,args);
    }
}
