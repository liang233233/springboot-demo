package com.gupao.springbootdemo.controller.desingParttern.proxy;


import com.gupao.springbootdemo.controller.desingParttern.proxy.dynamic.MyCglibProxy;
import com.gupao.springbootdemo.controller.desingParttern.proxy.dynamic.MyJdkProxy;

/**
 * 代理模式
 */
public class Client {
    public static void main(String[] args) {
        // jdk proxy
        // 易错点：此处只能转为目标对象的接口
        MyTargetApi jdkProxy = (MyTargetApi) new MyJdkProxy(new MyJdkTarget()).getProxy();
        jdkProxy.getMassage("jdk");
        System.out.println("===========");
        //cglib proxy
        MyCglibTarget cglibProxy = (MyCglibTarget) new MyCglibProxy(new MyCglibTarget()).getProxy();
        cglibProxy.getCglibMassage("cglib");
    }
}
