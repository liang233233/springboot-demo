package com.gupao.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class K8SController {

    @Value("${k8s.type}")
    public String type;

    @RequestMapping("/k8s")
    public String k8s() throws UnknownHostException {
        String name = InetAddress.getLocalHost().getHostName().toString();

        return "hello K8s" + type + "----" + name;
    }
}
