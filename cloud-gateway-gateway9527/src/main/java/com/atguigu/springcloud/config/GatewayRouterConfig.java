package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: 硬编码形式配置路由 <br>
 * date: 2020/9/30 10:05 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Configuration              //标记是java配置类
public class GatewayRouterConfig {
    /**
     * 配置一个id为router-name的路由规则 当访问地址http://localhost:9827/guonei时会跳转到http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
     return routeLocatorBuilder.routes().route("com_new_atguigu",r->r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
      /*return routeLocatorBuilder.routes().route("gs_admin",r->r.path("/order/**")
              .filters(item->item.hystrix(config -> config.setName("myserviceOne").setFallbackUri("forward:/hystrix/paymentInfo_TimeOut")))
              .uri("http://localhost:9000/hystrix/paymentInfo_TimeOut/*")).build();*/
    }
}
