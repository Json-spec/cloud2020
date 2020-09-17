package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: ProviderForZookeeperApplication8004 <br>
 * date: 2020/9/15 10:32 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderForZookeeperApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderForZookeeperApplication8004.class,args);
    }
}
