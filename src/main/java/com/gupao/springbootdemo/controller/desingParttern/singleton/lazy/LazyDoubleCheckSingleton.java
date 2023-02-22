package com.gupao.springbootdemo.controller.desingParttern.singleton.lazy;

/**
 *  懒汉式单例
 */
public class LazyDoubleCheckSingleton {
    private static volatile LazyDoubleCheckSingleton singleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public LazyDoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
