package com.atguigu.springcloud.com.atguigu.myRule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon负载均衡策略  自定义的策略不能放在被ComponentScan扫描的父包和子包下(保证自定义策略不要被ComponentScan注解扫描)
 *
 * 使用自定义ribbon策略需要在主启动类上加上 RibbonClient(value="调用的服务提供者服务名称" configuration = MyRuleConfig.class(注：具体策略类))
 *
 *
 * Ribbon：客户端的负载均衡，底层主要是IRule——RestTemplate 实现  一般情况下使用默认的负载均衡策略。
 *
 *
 */
@Configuration
public class MyRuleConfig {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
