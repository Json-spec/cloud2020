package com.atguigu.springcloud.server;

import com.atguigu.springcloud.entityes.Payment;

/**
 * description: HystrixServer <br>
 * date: 2020/9/28 17:23 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
public interface HystrixTestServer {

    Payment selectByid(Long id);

    Payment selectById(Long id);
}
