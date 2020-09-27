package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entityes.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface paymentHystrixMapper {
    Payment selectById(Long id);
}
