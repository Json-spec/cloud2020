package com.atguigu.springcloud.alibaba.myHandler;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TestSentinelHandler {

    //降级类中的降级方法必须是static的规定


    public  static String getIndex3(){
        return UUID.randomUUID().toString()+" 请求index3的方法中的降级类对应的index3执行了降级";
    }

    public  static String getIndex4(){
        return UUID.randomUUID().toString()+" 请求index4的方法中的降级类对应的index4执行了降级";
    }
}
