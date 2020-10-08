package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局网管过滤器的配置
 */
@Component
//简单的自定义网关过滤的逻辑
public class MyLogGatewayFilterConfig implements GlobalFilter , Ordered {
   private final static Logger log = LoggerFactory.getLogger(MyLogGatewayFilterConfig.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************come in myLogGatewayFilterConfig*********");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");        //获取用户名
        if(uname==null){                                                                  //判断用户名
            log.info("*********用户名为null，非法用户*********************");
             exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
             return exchange.getResponse().setComplete();                                //响应状态码
        }
        return chain.filter(exchange);                                                  //网关过滤链上面过滤成功进行下一个过滤
    }

    /**
     * return 的数字越小界别越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
