package com.codingislove.PGPD.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DRestController {

    // Add code for Hello World
    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }
}
