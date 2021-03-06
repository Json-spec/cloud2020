package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.feginclient.PaymentHystrixFeginClient;
import com.atguigu.springcloud.feignclient.PaymentFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description: OrderController <br>
 * date: 2020/9/7 10:54 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@RestController               //controller层并返回json格式
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);  //日志打印
    private final String URL = "http://localhost:8001/";        //写死的restTemplate调用远程服务扩展性不好而且不能实现负载均衡的效果

    private final String URL_Banlance = "http://CLOUD-PAYMENT-SERVICE";  //使用要调用的服务的名称即可实现扩展和负载均衡效果前提是在RestTemplate配置类对象上加上@LoadBanlence注解开启负载均衡
    @Autowired
    private RestTemplate restTemplate;           //注入在config文件夹中定义的java配置类中的RestTemplate对象（通过RestTemplate形式调用的对象）

    @Autowired
    private PaymentFeignClient paymentFeignClient;  //注入openFeign的接口 （通过openFeign的形式调用微服务，也是现当代主流方式推荐使用）

    @Autowired
    private PaymentHystrixFeginClient paymentHystrixFeginClient;  //注入openFegin接口(这个接口是为了测试Hystrix熔断的调用的是cloud-provider-payment-server8003服务)

//测试的是RestTramplate模板的使用
    @RequestMapping(value = "/consumer/payment/{id}")     //请求地址
    public CommonResult getpaymentById(@PathVariable("id") Long id) {  //从地址栏接收参数
        return restTemplate.getForObject(URL_Banlance + "/payment/get/" + id, CommonResult.class);
    }

    @RequestMapping(value = "/consumer/payment/create")   //请求地址
    public CommonResult create(@RequestBody Payment payment) {         //@RequestBody 通常接收一个json格式的字符串对象ajax的请求头是 Context-type=application/json;
        return restTemplate.postForObject(URL_Banlance + "/payment/create/", payment, CommonResult.class);
    }

    /**
     * 使用restTemplate中的getForEntity形式调用服务       restTemplate.getForEntity返回一个相应体
     *
     * @param id
     * @return
     */
    @RequestMapping("/consumer/restTemplate/{id}")      //请求地址
    public CommonResult getPaymentMsg(@PathVariable("id") Long id) {      //从地址栏接收参数
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(URL_Banlance + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            CommonResult body = forEntity.getBody();
            return body;
        } else {
            return new CommonResult(444, "查询失败");
        }
    }

    @RequestMapping("/consumer/restTemplate/postForEntity/{id}")          //请求地址
    public CommonResult getPaymentMsgForEntity(@PathVariable("id") Long id) {       //从地址栏接收参数
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(URL_Banlance + "/payment/get/" + id, null, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "查询失败");
        }
    }

    //上面是通过ribbon+RestTemplate形式调用服务提供者，下面是通过openFegin技术调用服务提供者推荐使用（测试openFegin使用）
    @RequestMapping("/consumer/openFegin/{id}")          //请求地址（查询）
    public CommonResult getPaymentMsgForOpenFegin(@PathVariable("id") Long id){    //参数栏去参数
        CommonResult commonResult = paymentFeignClient.getpaymentById(id);
        return commonResult;
    }

    @RequestMapping("/consumer/openFeign/create")   //请求地址（插入）
    public CommonResult createPaymentMsgOpenFegin(@RequestBody Payment payment){ //@RequestBody 通常接收一个json格式的字符串对象ajax的请求头是 Context-type=application/json;
        CommonResult commonResult = paymentFeignClient.create(payment);
        return commonResult;
    }

    //上面是通过openFegin形式调用服务提供者，下面是通过openFegin技术调用服务提供者推荐使用（测试openFegin调用微服务从而引出熔断的概念和测试）
    @RequestMapping("/consumer/openFeginByHystrixToOk/{id}")  //调用的服务立刻返回的
    public String getpaymentMsgForOpenfeginByHystrixToOk(@PathVariable("id") Long id){
        return paymentHystrixFeginClient.paymentInfo_Ok(id);
    }

    @RequestMapping("/consumer/openFeginHystrixToTimeOut/{id}") ////调用的服务设置了延迟3秒返回  （目的使用Jmeter工具模拟高并发测试Hsytrix熔断）
    public String getPaymentMsgForOpenFeginByHystrixToTimeOut(@PathVariable("id") Long id) throws InterruptedException {
        return paymentHystrixFeginClient.paymentInfo_TimeOut(id);
    }
}
