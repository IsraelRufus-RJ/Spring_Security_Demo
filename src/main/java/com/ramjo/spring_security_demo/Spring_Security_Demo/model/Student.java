package com.ramjo.spring_security_demo.Spring_Security_Demo.model;

public class Student {
    private int rollno;
    private String firstname;
    private String lastname;

    public Student(){}

    public Student(int rollno, String firstname, String lastname){
        this.rollno = rollno;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public int getRollno(){
        return this.rollno;
    }

    public void setRollno(int rollno){
        this.rollno = rollno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
