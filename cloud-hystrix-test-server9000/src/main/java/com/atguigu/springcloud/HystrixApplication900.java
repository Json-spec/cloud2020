package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * description: HystrixApplication900 <br>
 * date: 2020/9/28 17:14 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
//此模块是为了单纯测试Hytrix的熔断机制为整合任何技术，在hystrix和openfegin一起使用的情况下回调的方法就没有通常会使用@FeginClient中的fallbackFactory属性进行指定一个fallbackFactory<T>工厂接口形式
//具体项目中这种单纯的方式需要避免一般都是和openfegin一起使用的   具体使用实例请参照 cloud-provider-payment-fegin-hysreix-server8080模块
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker()
public class HystrixApplication900 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication900.class,args);
    }


    /*   此配置是为了服务监控而配置的,与服务容错本身无关,springcloud升级后的bug
    servletRegistrationBean因为springboot的默认路径不是"/hystrix.stream",
    只要在自己的项目中配置上下面的servlet的就可以。*/
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);    registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");    return registrationBean;
    }
    //注意；使用dashboard监控平台的时候需要引入spring-boot-starter-actuator这个依赖jar包，并且在主启动类开启了@EnableCircuitBreaker注解方可进行监控
    //cloud-hystrix-test-dashboard是监控平台，例如他监控9000这个服务，因此在启动服务时候输入localhost:9001(端口)/hystrix  ----> 在界面地址中输入监控的对象localhost:9000/hystrix.stream即可看到图形化界面
}
