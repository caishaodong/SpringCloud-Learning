package com.dong.springcloud.feignconsumer.service.impl;

import com.dong.springcloud.feignconsumer.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-12-03 13:55:00
 **/
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        return "hello fallback";
    }
}