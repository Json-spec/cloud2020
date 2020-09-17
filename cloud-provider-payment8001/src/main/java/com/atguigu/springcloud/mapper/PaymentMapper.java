package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entityes.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description: PaymentMapper <br>
 * date: 2020/9/7 10:20 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Mapper
public interface PaymentMapper {

    public Payment getpaymentById(@Param("id") Long id);

    public int create(Payment payment);
}
