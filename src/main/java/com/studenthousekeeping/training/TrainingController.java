package com.studenthousekeeping.training;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    } 
}
