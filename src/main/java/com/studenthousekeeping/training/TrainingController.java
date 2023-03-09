package com.studenthousekeeping.training;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {
    
    @GetMapping("/")
    public String index(){
        return "Welcome to my website!";
    }
    
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/helloA")
    public List<String> helloA(){
        return List.of("Hello", "World");
    }

    @GetMapping("/student")
    public List<Student> student(){
        return List.of(
            new Student(
                "Mariam",
                "Abdul",
                "Biology",
                "2",
                LocalDate.of(2000,Month.JANUARY,5)
            )
        );
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "hello world";
    }
}
