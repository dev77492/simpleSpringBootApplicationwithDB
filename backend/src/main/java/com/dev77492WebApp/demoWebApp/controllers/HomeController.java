package com.dev77492WebApp.demoWebApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "Welcome to dev77492 world!";
    }
    @RequestMapping("/about")
    public String about(){
        return "This is about section of amazing world of dev77492...";
    }
}
