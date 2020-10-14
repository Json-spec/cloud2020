package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: ConfigClientApplication3346 <br>
 * date: 2020/10/13 16:07 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication3346 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3346.class,args);
    }
}
