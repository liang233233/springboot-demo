package com.gupao.springbootdemo.controller.desingParttern.delegete;

/**
 * @Classname Hr
 * @Description TODO
 * @Date 2021/8/3 1:31 下午
 * @Creator naoling
 */
public class Hr extends Employee{
    @Override
    public String hiring() {
        System.out.println("Hr.hiring");
        return "招人";
    }
}
