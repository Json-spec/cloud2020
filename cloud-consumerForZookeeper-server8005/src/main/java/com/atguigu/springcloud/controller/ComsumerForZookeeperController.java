package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description: ComsumerForZookeeperController <br>
 * date: 2020/9/16 15:45 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController
public class ComsumerForZookeeperController {
    @Autowired
    private RestTemplate restTemplate;

   // private String  URL_Prifix = "http://127.0.0.1:8004"; 写死的http地址不利于扩展
    private String  URL_Prifix = "http://zookeeper-server";  //zookeeper注册中心上注册的微服务名称这样利于扩展(此服务名可以通过在zookeeper的Client端查找通过 ls / 一层一层查找，，get /xxx 是查看zookeeper上注册的节点具体信息) 注册到zookeeper的节点均属于临时节点

    @RequestMapping("/getConsumer/for/zookeeper")
    public String getMsgForZookeeper(){
        String url_sufix = "/provider/zookeeper";
        String all_url = URL_Prifix + url_sufix ;
        String forObject = restTemplate.postForObject(all_url,null, String.class);
        return forObject;

    }
}
