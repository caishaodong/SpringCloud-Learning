package com.dong.springcloud.helloservice.controller;

import com.dong.springcloud.helloservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-11-26 14:28:58
 **/
@RestController("/")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {

        LOGGER.info("===>services: " + discoveryClient.getServices());
        LOGGER.info("===>description: " + discoveryClient.description());
        LOGGER.info("===>order: " + discoveryClient.getOrder());

        int seconds = new Random().nextInt(3000);
        if (seconds > 1000) {
            throw new RuntimeException("Custom exception....");
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("hello-service");
        return "/hello, host:" + instances.get(0).getHost() + ", addr: " + request.getLocalAddr() + ", port: " + request.getLocalPort() + ", service_id: " + instances.get(0).getServiceId();
    }

    @GetMapping("/hello1")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(null, name, age);
    }

    @PostMapping("/hello3")
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + "," + user.getAge();
    }

}