package com.gupao.springbootdemo.controller.desingParttern.delegete;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname Boss
 * @Description TODO
 * @Date 2021/8/3 1:29 下午
 * @Creator naoling
 */
public class Boss {

    private static final Map<String, Employee> TASK_EMP_MAP = new ConcurrentHashMap<>();

    static {
        TASK_EMP_MAP.put("hiring", new Hr());
        TASK_EMP_MAP.put("coding", new Coder());
    }

    public Employee request(String task) {
        return TASK_EMP_MAP.get(task);
    }
}
