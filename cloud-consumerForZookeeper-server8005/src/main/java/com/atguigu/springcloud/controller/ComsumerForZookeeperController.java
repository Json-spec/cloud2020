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

    private String  URL_Prifix = "http://127.0.0.1:8004";

    @RequestMapping("/getConsumer/for/zookeeper")
    public String getMsgForZookeeper(){
        String url_sufix = "/provider/zookeeper";
        String all_url = URL_Prifix + url_sufix ;
        String forObject = restTemplate.postForObject(all_url,null, String.class);
        return forObject;

    }
}
