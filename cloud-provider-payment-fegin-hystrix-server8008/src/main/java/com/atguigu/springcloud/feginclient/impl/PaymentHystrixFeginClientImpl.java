package com.atguigu.springcloud.feginclient.impl;

import com.atguigu.springcloud.feginclient.PaymentHystrixFeginClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * description: Hystrix的自我保护机制的实现类实现openFegin的接口其作为泛型FallbackFactory<openFegin的接口名> 并通过匿名内部类的方式重写接口方法</><br>
 * date: 2020/9/28 11:29 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Component                    //@Component标记能被扫描到加入到容器中
public class PaymentHystrixFeginClientImpl implements FallbackFactory<PaymentHystrixFeginClient> {          //继承openFegin接口  FallbackFactory<openFegin的接口>

    @Override
    public PaymentHystrixFeginClient create(Throwable throwable) {                                         //匿名内部类的方式重写openFegin的接口方法
        return new PaymentHystrixFeginClient() {
            @Override
            public String paymentInfo_Ok(Long id) {
                return "系统连接异常，进入Hystrix的保护机制，请重新访问";                                    //Hystrix的保护机制通知内容
            }

            @Override
            public String paymentInfo_TimeOut(Long id) throws InterruptedException {
                return "系统未知错误，请重新访问，现已进入Hystrixd的自我保护机制";                             //Hystrix的保护机制通知内容
            }
        };
    }
}
