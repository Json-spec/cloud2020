package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration          //标准是一个java配置类
public class FeginLoggerConfig {

    @Bean
   public  Logger.Level loggerFegin(){   //常见fegin的调用服务打印详细日志Bean对象
        return  Logger.Level.FULL;
    }
}
