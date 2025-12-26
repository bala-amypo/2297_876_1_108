package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataFetchController {

    @GetMapping("/datafetch")
    public String dataFetch(){
        return "AIDS";
    }

}