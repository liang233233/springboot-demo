package com.gupao.springbootdemo.controller.desingParttern.singleton.lazy;

/**
 * 懒汉式单例
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
    }

    public LazyInnerClassSingleton getSingleton() {
        return SingletonInnerClass.singleton;
    }

    private static class SingletonInnerClass {
        private static final LazyInnerClassSingleton singleton = new LazyInnerClassSingleton();
    }
}
