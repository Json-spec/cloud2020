package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * description: 前台交互的公共类 <br>
 * date: 2020/9/4 18:09 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Data
@NoArgsConstructor          //lombok中无参构造方法
@ToString                   //toString方法
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
       this.code=code;
       this.message=message;
    }
}
