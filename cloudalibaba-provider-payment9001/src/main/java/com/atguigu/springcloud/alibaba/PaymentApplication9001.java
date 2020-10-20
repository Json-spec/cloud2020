package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description: PaymentApplication9001 <br>
 * date: 2020/10/19 14:08 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2  //开启swagger2的功能注解
public class PaymentApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9001.class,args);
    }
}
