package com.codingislove.PGPD.rest;

import com.codingislove.PGPD.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    // Define a field that loads data only once
    @PostConstruct  // To make data more readable and optimized
    public void loadData(){
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Qasim", "Ali"));
        theStudent.add(new Student("Nimal", "Shrma"));
        theStudent.add(new Student("Babar", "Azam"));
        theStudent.add(new Student("Hagwen", "Ollie"));
    }

    // define endpoints for '/students' - return a list of students
    @GetMapping("/students")
    public List<Student> getStudent(){
        loadData();

        return theStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // Just index from the list and keep te things simple

        // check the studentId again list size
        if(studentId>= theStudent.size() || studentId < 0){
            throw new StudentNotFoundException("Student not found - " + studentId);
        }
        return theStudent.get(studentId);
    }

    // Add an exception handler using ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc){

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return responsibility
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
