package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * description: ConsumerForZookeeperApplication8005 <br>
 * date: 2020/9/16 15:42 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication    //springBoot的主启动注解是一个复合注解包括（SpringBootConfiguration , EnableAutoConfiguration,ComponentScan）三个主要注解
@EnableDiscoveryClient   //开启注册中心客户端的服务发现（注解:可以支持eureka、zookeeper、nocas注册中心） @EnableEurekaClient 此注解只支持eureka的注册中心 项目中通常使用@EnableDiscoveryClient
public class ConsumerForZookeeperApplication8005 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerForZookeeperApplication8005.class,args);
    }

    @Bean
    @LoadBalanced //如果不加负载均衡在调用的时候可能会出现异常There was an unexpected error (type=Internal Server Error, status=500.I/O error on GET request for "http://zookeeper-server/provider/zookeeper": zookeeper-server; nested exception is java.net.UnknownHostException: zookeeper-serverorg.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://zookeeper-server/provider/zookeeper": zookeeper-server; nested exception is java.net.UnknownHostException: zookeeper-server)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}


