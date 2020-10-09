package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * description: ConfigApplication3344 <br>
 * date: 2020/10/9 14:05 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication            //springboot的启动类注解
@EnableDiscoveryClient           //服务发现(服务注册到eureka的注册中心中)
@EnableConfigServer             //开启Springcloud的分布式配置中心的服务端
public class ConfigApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication3344.class,args);
    }
}
