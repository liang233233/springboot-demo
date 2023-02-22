package com.gupao.springbootdemo.controller.jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackController {
    public static long count = 0;

    public void method(long i) {
        System.out.println(count++);
        method(i);
    }

    /**
     * 栈溢出
     *
     *  -XX:ThreadStackSize=100k
     *
     *  -Xss100k
     *
     * java.lang.StackOverflowError: null
     *
     */
    @GetMapping("/stack")
    public void heap() {
        method(0);
    }
}