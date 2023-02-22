package com.gupao.springbootdemo.controller.desingParttern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname ContainerRegisterSingleton
 * @Description TODO
 * @Date 2021/8/2 6:39 下午
 * @Creator naoling
 */
public class ContainerRegisterSingleton {
    private static final Map<String, Object> CONTAINER = new ConcurrentHashMap<>();

    static {
        CONTAINER.put("key1", new Object());
        CONTAINER.put("key2", new Object());
        CONTAINER.put("key3", new Object());
    }

    public Object getSingleton(String key) {
        return CONTAINER.containsKey(key) ? CONTAINER.get(key) : null;
    }

}
