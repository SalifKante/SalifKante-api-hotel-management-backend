package com.kantes.hotel;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {
    @GetMapping("/")
    String message() {
        return "Hotel App";
        
    }
}
