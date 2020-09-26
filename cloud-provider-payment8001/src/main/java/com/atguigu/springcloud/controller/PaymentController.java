package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: PaymentController <br>
 * date: 2020/9/7 10:17 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController              //controller层并返回json格式
public class PaymentController {
    @Value("${server.port}")
    private String port ;              //取配置文件中的值

    @Autowired
    private PaymentService paymentService;          //注入server层对象（controller调serveice ， service调mapper）

    @RequestMapping("/payment/get/{id}")           //请求地址
    public CommonResult getpaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getpaymentById(id);
        return new CommonResult<Payment>(200, "查询成功,端口是:"+port, payment);
    }

    @RequestMapping("/payment/create")          //请求地址
    public CommonResult create(@RequestBody Payment payment) {           //@RequestBody 通常接收一个json格式的字符串对象ajax的请求头是 Context-type=application/json;
        int i = paymentService.create(payment);
        boolean flag = false;
        if (flag = i > 0 ? true : false) {
            return new CommonResult(200, "插入成功,端口是:"+port, flag);
        } else {
            return new CommonResult(444, "插入失败", flag);
        }
    }
}
