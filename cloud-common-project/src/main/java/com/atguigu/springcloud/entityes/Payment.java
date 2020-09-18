package com.atguigu.springcloud.entityes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * description: 实体类 <br>
 * date: 2020/9/4 18:06 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Data                    //lombok省略getter/setter方法
@ToString               //lombok的ToSting方法
@AllArgsConstructor      //lombok全参构造方法
@NoArgsConstructor        //lombok无参构造方法
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
