package com.dong.springcloud.feignconsumer.service;

import com.dong.springcloud.feignconsumer.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-12-03 13:50:44
 **/
//@FeignClient(value = "hello-service", fallback = HelloServiceImpl.class)
public interface HelloService {

    @GetMapping("/hello")
    String hello();

}
