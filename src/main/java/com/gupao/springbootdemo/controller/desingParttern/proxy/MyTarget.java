package com.gupao.springbootdemo.controller.desingParttern.proxy;

/**
 * @Classname MyTarget
 * @Description TODO
 * @Date 2021/8/3 6:56 下午
 * @Creator naoling
 */
public class MyTarget implements MyTargetApi{
    @Override
    public String getMassage(String name) {
        System.out.println("调用目标方法 MyTarget.getMassage");
        return "";
    }
}
