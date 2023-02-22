package com.gupao.springbootdemo.controller.desingParttern.proxy;

/**
 * @Classname MyCglibTarget
 * @Description TODO
 * @Date 2021/8/3 12:59 下午
 * @Creator naoling
 */
public class MyCglibTarget {
    public String getCglibMassage(String name) {
        System.out.println("执行 MyCglibTarget.getCglibMassage");
        return "getCglibMassage";
    }
}
