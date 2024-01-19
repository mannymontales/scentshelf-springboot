package com.app.scentshelf.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Tester {
    
    @GetMapping("/test")
    public String tester() {
        return "this is working";
    }
}
