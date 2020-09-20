package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController        //标记是controller层返回至以json格式返回
public class ConsumerForConsulController {

    @Autowired
    private RestTemplate restTemplate;  //注入config包下的创建的Bean容器中的RestTemplate的对象

    @Value("${server.port}")
    private String port;

    //private  String URL = "http://127.0.0.1:8006";      //这种ip+端口是写死的不易与扩因此需改成微服务名调用
    private String URL = "http://cloud-providerForConsul-paymentServer8006";     //微服务名调用

    @RequestMapping("/consumer/consul")
    public String consumerGetMsg(){
        StringBuffer sb = new StringBuffer();
         String result = restTemplate.postForObject(URL+"/consul/provider",null,String.class);
         return result+sb.append(",客户端的端口是：").append(port).toString();
    }
}
