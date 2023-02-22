package com.gupao.springbootdemo.controller.desingParttern.factory.ordinary;

/**
 * @Classname ConcreteFactory1
 * @Description TODO
 * @Date 2021/8/2 7:24 下午
 * @Creator naoling
 */
public class ConcreteFactory1 implements OrdinaryFactory {
    @Override
    public AbsProduct createProduct() {
        return new ConcreteProduct1();
    }
}
