package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entityes.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: PaymentTestMapper <br>
 * date: 2020/9/28 17:49 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Mapper
public interface PaymentTestMapper {
    Payment selectByid(Long id);

    Payment selectById(Long id);
}
