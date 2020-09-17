package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * description: CommonResult <br>
 * date: 2020/9/4 18:09 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Data
@NoArgsConstructor
@ToString
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
