package com.gupao.springbootdemo.controller.desingParttern.proxy;

/**
 * @Classname MyJdkTarget
 * @Description TODO
 * @Date 2021/8/3 12:56 下午
 * @Creator naoling
 */
public class MyJdkTarget implements MyTargetApi {

    @Override
    public String getMassage(String name) {
        System.out.println("执行MyJdkTarget.getMassage");
        return "jdk Massage";
    }
}
