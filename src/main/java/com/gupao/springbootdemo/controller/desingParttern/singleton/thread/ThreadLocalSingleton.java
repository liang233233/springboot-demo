package com.gupao.springbootdemo.controller.desingParttern.singleton.thread;

/**
 * @Classname ThreadLocalSingleton
 * @Description 在一个线程中为单例，???
 * @Date 2021/8/2 6:54 下午
 * @Creator naoling
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton() {
    }

    public ThreadLocalSingleton getSingleton() {
        return threadLocal.get();
    }
}
