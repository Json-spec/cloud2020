package com.atguigu.springcloud.alibaba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-server}")
    private String url;

    @RequestMapping(value="/consumer/index")
    public String getConsumerIndex(){
        return restTemplate.getForObject(url+"/index",String.class);
    }

}
