package com.atguigu.springcloud.alibaba.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.myHandler.TestSentinelHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSentinelController {


    //测试单个请求时候降级的方法。在每个请求后都加有降级方法 blockhandler指定降级方法
    @RequestMapping("/index1")
    @SentinelResource(value="index1" , blockHandler = "getIndex1")
    public String Index1(){
        return UUID.randomUUID().toString()+" index1的方法执行了";
    }

    public String getIndex1(){
        return UUID.randomUUID().toString()+" index1的降级方法执行了";
    }

    @RequestMapping("/index2")
    @SentinelResource(value = "index2" , blockHandler = "index2")
    public String Index2(){
        return UUID.randomUUID().toString()+" index2的方法执行了";
    }
    public String getIndex2(){
        return UUID.randomUUID().toString()+" index2的降级方法执行了";
    }


    //服务降级的方法统一放在一个类中通过@SentinelResource注解中的blockHandlerClass属性指定降级的类，在通过blockhandler执行降级类中具体的的方法
    //这样就把业务和降低的提示进行了拆分 推荐使用
    @RequestMapping("/index3")
    @SentinelResource(value = "index3" , blockHandlerClass = TestSentinelHandler.class , blockHandler = "index3")
    public String Index3(){
        return UUID.randomUUID().toString()+" index3的方法执行了";
    }

    @RequestMapping("/index4")
    @SentinelResource(value = "index4" , blockHandlerClass = TestSentinelHandler.class , blockHandler = "index4")
    public String Index4(){
        return UUID.randomUUID().toString()+" idnex4的方法执行了";
    }



}
