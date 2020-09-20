package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController    //标记是controller层并以json格式返回数据
public class ProviderForConsulController {

    @Value("${server.port}")
    private String port ;     //@Value注解表示从yml配置文件中去除相应配置的值


    @RequestMapping("/consul/provider")      //访问的请求地址
    public String getConsulForMsg(){

        return "This is Consul with port is:"+port+",系列号:"+ UUID.randomUUID().toString();

    }
}
