package com.ramjo.spring_security_demo.Spring_Security_Demo.service;

import java.util.ArrayList;
import java.util.List;
import com.ramjo.spring_security_demo.Spring_Security_Demo.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    List<Student> studentList = new ArrayList<>();

    StudentService(){
        studentList.add(new Student(1, "Israel", "Rufus"));
    }

    public List<Student> getStudents(){
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }
}
