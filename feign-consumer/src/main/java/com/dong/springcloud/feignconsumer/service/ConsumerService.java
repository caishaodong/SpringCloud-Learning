package com.dong.springcloud.feignconsumer.service;

import com.dong.springcloud.feignconsumer.config.FullLogConfiguration;
import com.dong.springcloud.feignconsumer.model.User;
import com.dong.springcloud.feignconsumer.service.impl.ConsumerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-12-03 14:31:32
 **/
@FeignClient(value = "hello-service", fallbackFactory = ConsumerServiceImpl.class, configuration = FullLogConfiguration.class)
public interface ConsumerService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User user);

}
