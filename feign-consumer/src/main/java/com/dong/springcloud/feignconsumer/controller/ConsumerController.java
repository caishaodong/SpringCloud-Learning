package com.dong.springcloud.feignconsumer.controller;

import com.dong.springcloud.feignconsumer.model.User;
import com.dong.springcloud.feignconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-12-03 13:52:41
 **/
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/feign-consumer")
    public String hello() {
        String result = consumerService.hello();
        return result;
    }

    @GetMapping("/feign-consumer2")
    public String hello2() {
        StringBuilder builder = new StringBuilder();
        builder.append(consumerService.hello()).append("\r\n")
                .append(consumerService.hello("dongdong")).append("\r\n")
                .append(consumerService.hello("dongdong", 20)).append("\r\n")
                .append(consumerService.hello(new User(null, "dongdong", 20)));
        System.out.println(builder.toString());
        return builder.toString();
    }

}