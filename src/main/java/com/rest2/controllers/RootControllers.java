package com.rest2.controllers;

import com.rest2.api.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RootControllers {

    private List<Student> student1;

    /*
        why use @PostConstruct annotation???
        -> because when the constructor is called, the bean is not yet initialized
           i.e. no dependencies are injected. In the @PostConstruct method the bean
           is fully initialized And you can use the dependencies. because this is the
           contract that guarantees that this method will be invoked only once in the bean lifecycle.
     */

    @PostConstruct
    public void loadData(){
        student1 = new ArrayList<>();
        student1.add(new Student(1,"alamin","A","B+"));
        student1.add(new Student(2,"khokon","B","B-"));
        student1.add(new Student(3,"razu","C","A+"));
        student1.add(new Student(3,"fardin","d","A-"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
       return student1;
    }

    /*
        why we use {studentId}??? what is this???
        -> this is Path Variable
        -> With this Path Variable, we can show a single student's value, from a list of students
           List<Student> in JSON format.

        ->> but this is an problem. if our student list/id is [0,1,2,3,4] I mean our have 5 students but
            if we search list/id [55] in our browser then it gives (505 server error) index out of bound.
     */
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return student1.get(studentId);
    }
}