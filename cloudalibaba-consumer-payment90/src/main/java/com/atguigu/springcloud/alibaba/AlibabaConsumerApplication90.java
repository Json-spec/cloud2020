package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class AlibabaConsumerApplication90 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerApplication90.class,args);
    }


    @Bean
    @LoadBalanced //restTemplate整合ribbo的负载均衡一定要加次注解不然会报错(不知道服务异常)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
