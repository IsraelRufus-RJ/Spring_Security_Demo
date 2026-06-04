package com.ramjo.spring_security_demo.Spring_Security_Demo.controller;

import com.ramjo.spring_security_demo.Spring_Security_Demo.model.Student;
import com.ramjo.spring_security_demo.Spring_Security_Demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping()
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }


    @GetMapping("/about")
    public String about(){
        return "About Us!";
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String sessionid = session.getId();
        return "Hello World!\nSessionID: " + sessionid;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(CsrfToken token){
        return token;
    }

}
