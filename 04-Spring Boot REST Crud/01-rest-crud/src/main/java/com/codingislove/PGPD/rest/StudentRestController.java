package com.codingislove.PGPD.rest;

import com.codingislove.PGPD.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // define endpoints for '/students' - return a list of students
    @GetMapping("/students")
    public List<Student> getStudent(){
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Qasim", "Ali"));
        theStudents.add(new Student("Nimal", "Shrma"));
        theStudents.add(new Student("Babar", "Azam"));
        theStudents.add(new Student("Hagwen", "Ollie"));

        return theStudents;
    }
}
