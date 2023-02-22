package com.gupao.springbootdemo.controller.desingParttern.factory.abstraction;

/**
 * 产品1的具体组成
 */
public class Product1ComponentConcrete implements ProductComponent {
    @Override
    public Component1 getProductComponent1() {
        return new Component1();
    }

    @Override
    public Component2 getProductComponent2() {
        return new Component2();
    }
}
