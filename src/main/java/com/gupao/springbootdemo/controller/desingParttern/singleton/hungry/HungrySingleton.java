package com.gupao.springbootdemo.controller.desingParttern.singleton.hungry;

/**
 * 饿汉式单例
 */
public class HungrySingleton {
    private final static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public HungrySingleton getSingleton() {
        return singleton;
    }
}
