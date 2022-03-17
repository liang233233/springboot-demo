package com.gupao.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class K8SController {

    @Value("${k8s.type}")
    public String type;

    @RequestMapping("/k8s")
    public String k8s() {
        return "hello K8s <br/>111222 " + type;
    }
}
