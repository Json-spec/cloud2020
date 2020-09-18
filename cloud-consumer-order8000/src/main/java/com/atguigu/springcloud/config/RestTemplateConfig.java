package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * description: RestTemplateConfig <br>
 * date: 2020/9/7 10:55 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Configuration              //标记java配置类
public class RestTemplateConfig {
    @Bean      //对象加入到bean容器中
    @LoadBalanced //如果不加负载均衡在调用的时候可能会出现异常There was an unexpected error (type=Internal Server Error, status=500.I/O error on GET request for "http://zookeeper-server/provider/zookeeper": zookeeper-server; nested exception is java.net.UnknownHostException: zookeeper-serverorg.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://zookeeper-server/provider/zookeeper": zookeeper-server; nested exception is java.net.UnknownHostException: zookeeper-server)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
