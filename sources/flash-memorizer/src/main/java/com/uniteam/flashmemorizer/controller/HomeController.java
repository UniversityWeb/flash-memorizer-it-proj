package com.uniteam.flashmemorizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String get() {
//        throw new RuntimeException();
        return "home";
    }
}
