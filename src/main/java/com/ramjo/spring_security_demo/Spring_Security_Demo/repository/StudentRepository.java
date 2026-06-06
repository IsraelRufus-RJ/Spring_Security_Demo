package com.ramjo.spring_security_demo.Spring_Security_Demo.repository;

import com.ramjo.spring_security_demo.Spring_Security_Demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
