package com.gupao.springbootdemo.controller.jvm;

import com.gupao.springbootdemo.model.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeapController {
    List<Brand> list = new ArrayList<Brand>();

    /**
     * 堆溢出测试
     *
     * 需要配置   初始化堆大小  / 最大堆大小    -Xms20M   -Xmx20M
     *
     *
     * 报错 :
     * Exception in thread "http-nio-8101-exec-1" java.lang.OutOfMemoryError: GC overhead limit exceeded
     *
     *
     * @return
     */
    @GetMapping("/heap")
    public String heap() {
        while (true) {
            list.add(new Brand());
        }
    }
}