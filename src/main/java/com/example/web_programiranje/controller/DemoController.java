package com.example.web_programiranje.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(path="hello")
    public String helloWorld(){
        return "Hi";
    }
}
