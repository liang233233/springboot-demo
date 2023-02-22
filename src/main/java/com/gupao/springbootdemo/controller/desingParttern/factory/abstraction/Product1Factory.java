package com.gupao.springbootdemo.controller.desingParttern.factory.abstraction;


/**
 * 创建产品1的工厂
 */
public class Product1Factory implements AbstractFactory {
    @Override
    public Component1 getProductComponent1() {
        return new Product1ComponentConcrete().getProductComponent1();
    }

    @Override
    public Component2 getProductComponent2() {
        return new Product1ComponentConcrete().getProductComponent2();
    }
}
