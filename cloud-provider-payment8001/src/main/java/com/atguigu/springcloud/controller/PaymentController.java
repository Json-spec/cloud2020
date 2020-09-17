package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/payment/get/{id}")
    public CommonResult getpaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getpaymentById(id);
        return new CommonResult<Payment>(200, "查询成功", payment);
    }

    @RequestMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        boolean flag = false;
        if (flag = i > 0 ? true : false) {
            return new CommonResult(200, "插入成功", flag);
        } else {
            return new CommonResult(444, "插入失败", flag);
        }
    }
}
