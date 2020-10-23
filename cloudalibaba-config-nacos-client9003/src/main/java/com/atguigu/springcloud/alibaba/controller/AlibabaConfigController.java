package com.atguigu.springcloud.alibaba.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: AlibabaConfigController <br>
 * date: 2020/10/23 17:23 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController
@RefreshScope
public class AlibabaConfigController {
    @Value("${config.info}")
    private String info;

    @RequestMapping("/index")
    public String getIndex(){
        return UUID.randomUUID()+" 分布式配置文件信息:"+info;
    }

}
