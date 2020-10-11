package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication            //springboot的启动类注解
@EnableDiscoveryClient           //服务发现(服务注册到eureka的注册中心中)
public class ConfigClientApplication3345 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3345.class,args);
    }
}
