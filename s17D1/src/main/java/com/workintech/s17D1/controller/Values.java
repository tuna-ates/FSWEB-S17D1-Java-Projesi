package com.workintech.s17D1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/values")
public class Values {
    @Value("${project.owner}")
    private String owner;
    @Value("${project.developer}")
    private String developer;
    @Value("${project.type}")
    private String type;
    @GetMapping
    public  void deneme(){
        System.out.println(" "+owner+" "+developer+" "+type);
    }
}
