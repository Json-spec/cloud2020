package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entityes.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description: PaymentMapper 的接口(dao层)  <br>
 * date: 2020/9/18 9:41 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Mapper          //标准是mapper类
public interface PaymentMapper {
    public Payment getpaymentById(@Param("id") Long id);

    public int create(Payment payment);
}
