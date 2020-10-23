package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: AlibabaConfigApplication9003 <br>
 * date: 2020/10/23 17:22 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConfigApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConfigApplication9003.class,args);
    }
}
