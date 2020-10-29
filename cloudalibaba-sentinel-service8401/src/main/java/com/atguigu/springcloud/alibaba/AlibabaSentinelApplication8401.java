package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description: AlibabaSentinelApplication8401 <br>
 * date: 2020/10/29 16:04 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class AlibabaSentinelApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelApplication8401.class, args);
    }
}
