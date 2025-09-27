package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/")
    public String home() {
        return "Welcome! 🎉 You are logged in";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring  !";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello, Spring Boot is running!";
    }

    @GetMapping("/greetings")
    public List<Map<String, Object>> getGreetings() {
        return greetingRepository.findAllRaw();
    }
}
