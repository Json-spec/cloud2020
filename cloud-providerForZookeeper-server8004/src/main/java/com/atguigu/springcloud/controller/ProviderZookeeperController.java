package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * description: ProviderZookeeperController <br>
 * date: 2020/9/15 10:33 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController
public class ProviderZookeeperController {
    //从配置文件获取端口使用@Value注解
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/provider/zookeeper")
    public String getZookeeper(){
        return "zookeeper with provider for client" + serverPort+":" + UUID.randomUUID().toString();
    }
}
