package com.lov2code.springboot.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restExample {
    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    @GetMapping("factorial")
    public String getFactorial(){
        return "Factorial of 5 is 120";
    }

    @GetMapping("fibonocci")
    public String getFibnocci(){
        return "Fibnocci of 5 is 3";
    }

//    Accessing resources/__.properties (Custom  properties)
    @Value("${coach.name}")
    private String name;
    @Value("${coach.age}")
    private Integer age;
    @GetMapping("Injection")
    public String getProperties(){
        return "Coach name is " + name + " and his age is " + age;
    }

}
