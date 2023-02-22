package com.gupao.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class K8SController {


    @GetMapping("/k8s")
    public String k8s(){
        return "hello K8s <br/>111222 ";
    }
}
