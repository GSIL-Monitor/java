package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Webcontroller {

    @RequestMapping("hello")
    public String back() {
        return "home";
    }
}
