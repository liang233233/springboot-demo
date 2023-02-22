package com.gupao.springbootdemo.controller.desingParttern.factory.ordinary;

/**
 * @Classname ConcreteProduct1
 * @Description TODO
 * @Date 2021/8/2 7:19 下午
 * @Creator naoling
 */
public class ConcreteProduct1 extends AbsProduct{
    @Override
    public String getName() {
        return "具体产品1";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
