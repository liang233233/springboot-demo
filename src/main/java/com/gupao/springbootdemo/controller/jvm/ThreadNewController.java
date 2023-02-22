package com.gupao.springbootdemo.controller.jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hliang
 */

@RestController
public class ThreadNewController {


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
    @GetMapping("/thread")
    public void thread() {
        while (true){
            new Thread(() -> {
                try {
                    Thread.sleep(200000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }




}
