package com.atguigu.springcloud.entityes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * description: Payment <br>
 * date: 2020/9/4 18:06 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
