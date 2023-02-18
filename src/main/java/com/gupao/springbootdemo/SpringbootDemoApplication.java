package com.gupao.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args){

        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
