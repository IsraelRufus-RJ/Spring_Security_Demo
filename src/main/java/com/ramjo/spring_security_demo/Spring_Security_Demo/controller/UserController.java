package com.ramjo.spring_security_demo.Spring_Security_Demo.controller;

import com.ramjo.spring_security_demo.Spring_Security_Demo.model.User;
import com.ramjo.spring_security_demo.Spring_Security_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
