package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.feginclient.PaymentHystrixFeginClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端的Hystrix的降级测试 （需要在启动类加上@EnableHystrix注解）
 *
 * 此类知识为了测试客户端的hystrix的降级功能。项目中通常不会使用此种方法进行，项目开发中通常使用在FeginClient接口类中创建FeginClient接口实现类实现接口进行fallback回调处理
 */
@RestController
//@DefaultProperties(defaultFallback = "paymentMsgForOpenfeginByHystrixToOk_fallback")     //标记是默认的降级所走的方法paymentMsgForOpenfeginByHystrixToOk_fallback(在具体方法上没有指定@HystrixCommand(fallbackMethod="")属性都算会走默认的回退方法)
public class OrderTestHystrixController {

    @Autowired
    private PaymentHystrixFeginClient paymentHystrixFeginClient;  //注入openFegin接口(这个接口是为了测试Hystrix熔断的调用的是cloud-provider-payment-server8003服务)

    //上面是通过openFegin形式调用服务提供者，下面是通过openFegin技术调用服务提供者推荐使用（测试openFegin调用微服务从而引出熔断的概念和测试）
    @RequestMapping("/consumer/openFeginByHystrix/{id}")  //调用的服务立刻返回的
    @HystrixCommand(fallbackMethod = "paymentMsgForOpenfeginByHystrixToOk_fallback") //指定降级的方法paymentMsgForOpenfeginByHystrixToOk_fallback
    //@HystrixCommand   //此注解没有加fallbackMethod属性因此会走全局的默认的回退方法,指定fallbackMethod属性应该走具体定义的专属回退方法
    public String getpaymentMsgForOpenfeginByHystrixToOk(@PathVariable("id") Long id){
        int i = 10 / 0 ;   //此句代码为了体现降级功能所写
        return paymentHystrixFeginClient.paymentInfo_Ok(id);
    }

    @RequestMapping("/consumer/openFeginHystrix/{id}") ////调用的服务设置了延迟3秒返回  （目的使用Jmeter工具模拟高并发测试Hsytrix熔断）
    @HystrixCommand(fallbackMethod = "PaymentMsgForOpenFeginByHystrixToTimeOut_fallback") //指定降级的方法PaymentMsgForOpenFeginByHystrixToTimeOut_fallback
    public String getPaymentMsgForOpenFeginByHystrixToTimeOut(@PathVariable("id") Long id) throws InterruptedException {
        Thread.sleep(7000);     //此句代码为了体现降级功能所写
        return paymentHystrixFeginClient.paymentInfo_TimeOut(id);
    }


    /**
     * 服务降级的方法
     */

    public String paymentMsgForOpenfeginByHystrixToOk_fallback(Long id){
        return "系统异常，请检查后再访问，默认的回退方法";
    }

    public String PaymentMsgForOpenFeginByHystrixToTimeOut_fallback(Long id){
        return "系统响应超时，请查证后再访问，PaymentMsgForOpenFeginByHystrixToTimeOut_fallback";
    }



//  注意:  出现服务降级情况（程序异常、超时、线程池/信号量满、服务熔断引发的降级）

        // 服务熔断(达到最大服务访问，服务拒绝访问)  服务降级--> 服务熔断-->链路恢复



}
