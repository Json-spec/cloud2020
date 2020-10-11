package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //分布式配置中心自动刷新的注解 需要配合yml文件中开启断点监控的配置一起使用以及pom中spring-boot-starter-actuator依赖一起使用
public class ConfigClientController {

    @Value("${config.msg}")              //获取分布式配置中心中的config.msg配置
    private String configInfo;

    @RequestMapping("/configInfoMsg")
    public String configInfoMsg(){
        return configInfo;             //restFul接口能访问到代表可以取到分布式配置中心github上的具体配置信息
    }
}
