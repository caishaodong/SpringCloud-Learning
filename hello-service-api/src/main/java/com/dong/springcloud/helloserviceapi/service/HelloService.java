package com.dong.springcloud.helloserviceapi.service;

import com.dong.springcloud.helloserviceapi.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: caishaodong
 * @Create: 2018-12-03 15:49:45
 **/
@RequestMapping("/refactor")
public interface HelloService {

    @GetMapping("/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello6")
    String hello(@RequestBody User user);
}
