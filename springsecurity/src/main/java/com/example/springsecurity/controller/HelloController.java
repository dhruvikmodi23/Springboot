package com.example.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String greet(HttpServletRequest req){
         return "hello" + req.getSession().getId() ;
    }

    @GetMapping("about")
    public String about(HttpServletRequest req){
        return "dhruvik" + req.getSession().getId() ;
    }

}
