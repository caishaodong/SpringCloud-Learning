package com.dong.springcloud.feignconsumer.service.impl;

import com.dong.springcloud.feignconsumer.model.User;
import com.dong.springcloud.feignconsumer.service.ConsumerService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-12-03 14:32:29
 **/
@Component
public class ConsumerServiceImpl implements FallbackFactory<ConsumerService> {

    @Override
    public ConsumerService create(Throwable throwable) {
        return new ConsumerService() {
            @Override
            public String hello() {
                return "hello fallback FallbackFactory...";
            }

            @Override
            public String hello(String name) {
                return "hello fallback FallbackFactory...";
            }

            @Override
            public User hello(String name, Integer age) {
                return new User();
            }

            @Override
            public String hello(User user) {
                return "hello fallback FallbackFactory...";
            }
        };
    }
}