package com.atguigu.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;


import java.util.List;

/**
 * 手写轮询方法的接口方法
 */
public interface MyLoadBalanceConfig {

    ServiceInstance getInstance(List<ServiceInstance> list);
}
