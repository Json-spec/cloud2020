package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration      //标记是java配置类
public class RestTeamplateConfig {

    @Bean     //把创建的RestTemplate对象加入到Bean容器中
    @LoadBalanced //开启客户端的负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
