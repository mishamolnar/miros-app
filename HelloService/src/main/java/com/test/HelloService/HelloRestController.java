package com.test.HelloService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {


    @GetMapping(value = "/hello")
    public String greet() {
        return "hello";
    }
}
