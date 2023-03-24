package org.wmm.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("helloworld")
    public String helloWorld(Integer code) {
        return "hello world " + code;
    }
}
