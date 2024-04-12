package com.example.onlinebankingapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPage {

    @GetMapping("/")
    public String sayHello() {
        return "Hello User!";
    }
}
