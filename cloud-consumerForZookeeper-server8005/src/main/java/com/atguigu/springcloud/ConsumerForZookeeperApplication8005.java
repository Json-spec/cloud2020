package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * description: ConsumerForZookeeperApplication8005 <br>
 * date: 2020/9/16 15:42 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerForZookeeperApplication8005 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerForZookeeperApplication8005.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}


