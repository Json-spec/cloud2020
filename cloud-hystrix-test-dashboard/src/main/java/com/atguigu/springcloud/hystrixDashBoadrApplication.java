package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * description: hystrixDashBoadrApplication <br>
 * date: 2020/9/29 11:22 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */

//注意；使用dashboard监控平台的时候需要引入spring-boot-starter-actuator这个依赖jar包，并且在主启动类开启了@EnableCircuitBreaker注解方可进行监控
//cloud-hystrix-test-dashboard是监控平台，例如他监控9000这个服务，因此在启动服务时候输入localhost:9001(端口)/hystrix  ----> 在界面地址中输入监控的对象localhost:9000/hystrix.stream即可看到图形化界面
@SpringBootApplication
@EnableHystrixDashboard    //开启hystrix的监控仪表盘dashboard的功能
public class hystrixDashBoadrApplication {
    public static void main(String[] args) {
        SpringApplication.run(hystrixDashBoadrApplication.class,args);
    }
}
