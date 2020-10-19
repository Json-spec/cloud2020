package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * springboot启动类微服务的入口
 */
@SpringBootApplication                                    //springBoot的主启动注解是一个复合注解包括（SpringBootConfiguration , EnableAutoConfiguration,ComponentScan）三个主要注解
@MapperScan("com.atguigu.springcloud.mapper.*")           //扫描Mapper层接口的类
@EnableDiscoveryClient   //开启注册中心客户端的服务发现（注解:可以支持eureka、zookeeper、nocas注册中心） @EnableEurekaClient 此注解只支持eureka的注册中心 项目中通常使用@EnableDiscoveryClient
@EnableCircuitBreaker() //开启SpringCloud中使用断路器，需要加上此注解
@EnableSwagger2
public class PaymentMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainApplication.class,args);
    }
}
