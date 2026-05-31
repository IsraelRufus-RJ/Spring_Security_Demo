package com.ramjo.spring_security_demo.Spring_Security_Demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public String homepage(){
        return "Home Page!";
    }

    @GetMapping("/about")
    public String about(){
        return "About Us!";
    }
}
