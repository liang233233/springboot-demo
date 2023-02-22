package com.gupao.springbootdemo.controller.desingParttern.delegete;

/**
 * @Classname Coder
 * @Description TODO
 * @Date 2021/8/3 1:31 下午
 * @Creator naoling
 */
public class Coder extends Employee {

    @Override
    public String coding() {
        System.out.println("Coder.coding");
        return "编码";
    }
}
