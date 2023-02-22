package com.gupao.springbootdemo.controller.desingParttern.proxy.ofstatic;


import com.gupao.springbootdemo.controller.desingParttern.proxy.MyTarget;

/**
 * @Classname StaticProxy
 * @Description TODO
 * @Date 2021/8/3 6:53 下午
 * @Creator naoling
 */
public class StaticProxy extends MyTarget {

    @Override
    public String getMassage(String name) {
        before();
        final String massage = super.getMassage(name);
        after();
        return massage;
    }

    private void before() {
        System.out.println("StaticProxy.before");
    }

    private void after() {
        System.out.println("StaticProxy.after");
    }
}
