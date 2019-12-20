package com.encoursa.app.coursemanagement.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    /* basic get */
    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }
}
