package com.atguigu.springcloud.alibaba.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: AlibabaSetinetController <br>
 * date: 2020/10/29 16:07 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController
public class AlibabaSetinetController {



    @RequestMapping("/index1")
    public String index1(){
        return UUID.randomUUID().toString()+" index1";
    }
    @RequestMapping("/index2")
    public String index2(){
        return UUID.randomUUID().toString()+" index2";
    }

}
