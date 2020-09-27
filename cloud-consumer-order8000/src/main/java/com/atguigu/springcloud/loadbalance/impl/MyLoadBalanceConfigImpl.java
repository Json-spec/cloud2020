package com.atguigu.springcloud.loadbalance.impl;

import com.atguigu.springcloud.loadbalance.MyLoadBalanceConfig;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写负载均衡轮询策略接口实现类
 */
@Component  //此注解作用是为了让容器能扫描到此类用@Component可以加载到容器中
public class MyLoadBalanceConfigImpl implements MyLoadBalanceConfig {

    private AtomicInteger atomicInteger = new AtomicInteger(0); //定义原子值

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 :current + 1 ;
        }while(!this.atomicInteger.compareAndSet(current,next));
            System.out.println("**第几次访问**next"+next);
            return next;
        }

    public ServiceInstance getInstance(List<ServiceInstance> list) {
        int index = getAndIncrement() % list.size();
        return list.get(index);
    }
}
