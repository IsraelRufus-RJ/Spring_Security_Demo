package com.ramjo.spring_security_demo.Spring_Security_Demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @GetMapping("/")
    public String home(){
        return "This is the HomePage<br>No Auth Required";
    }
}
