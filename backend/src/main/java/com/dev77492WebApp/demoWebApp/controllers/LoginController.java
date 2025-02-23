package com.dev77492WebApp.demoWebApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        return "Logged into the amazing world of dev77492 :)";
    }
}
