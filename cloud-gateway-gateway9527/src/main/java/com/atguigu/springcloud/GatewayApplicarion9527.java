package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: GatewayApplicarion9527 <br>
 * date: 2020/9/29 15:58 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
//注意：在gateway网关中不能引入spring-boot-starter-web的依赖，如果引入会报错的
//异步非阻塞式网关   zuul是阻塞式网关
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplicarion9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicarion9527.class,args);
    }
}


   /* Gateway()三大概念:
        路由：路由是构建网关的基本模块，它是由id，目标URI,一系列的断言和过滤器组成，如果断言为true则匹配该路由
        断言(Predicate):java8的新特性函数式接口
        过滤(Filter):指的是Spring框架中的GatewayFilter的实例，使用过滤器，可以在请求被路由前或者后对请求进行修改*/