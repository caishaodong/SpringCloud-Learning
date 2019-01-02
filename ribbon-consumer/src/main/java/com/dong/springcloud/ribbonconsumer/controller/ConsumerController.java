package com.dong.springcloud.ribbonconsumer.controller;

import com.dong.springcloud.ribbonconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Ribbon
 * @Author: caishaodong
 * @Create: 2018-11-26 15:59:48
 **/
@RestController("/")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        long start = System.currentTimeMillis();
        String result = consumerService.hello();
        long end = System.currentTimeMillis();

        System.out.println("请求共耗时：" + (end - start) + "毫秒");
        return result;
    }
}