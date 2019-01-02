package com.dong.springcloud.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-11-26 11:13:55
 **/
@RestController("/")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}