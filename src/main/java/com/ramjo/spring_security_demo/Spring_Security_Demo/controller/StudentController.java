package com.ramjo.spring_security_demo.Spring_Security_Demo.controller;

import com.ramjo.spring_security_demo.Spring_Security_Demo.model.Student;

import com.ramjo.spring_security_demo.Spring_Security_Demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student stdObj = studentService.addStudent(student);
        return ResponseEntity.created(URI.create("/student/" + stdObj.getRollno())).body(stdObj);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    //Extras
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
