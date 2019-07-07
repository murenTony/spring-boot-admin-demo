package com.nextclassai.admin.module.action.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ststorytony
 * @date 2019/7/6 15:27
 * Description:
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    @HystrixCommand(fallbackMethod = "error")
    public String helloWorld(String name) {
        int i = 10 / 0;
        return name + ": Hello world!";
    }

    public String error(String name) {
        return "Admin Service is down! name = " + name;
    }
}
