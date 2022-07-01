package com.rest2.controllers;

import com.rest2.api.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RootControllers {
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> student1 = new ArrayList<>();
        student1.add(new Student(1,"alamin","A","B+"));
        student1.add(new Student(2,"khokon","B","B-"));
        student1.add(new Student(3,"razu","C","A+"));
        student1.add(new Student(3,"fardin","d","A-"));
       return student1;
    }
}