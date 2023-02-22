package com.gupao.springbootdemo.controller.desingParttern.factory.abstraction;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2021/8/2 8:19 下午
 * @Creator naoling
 */
public class Client {
    public static void main(String[] args) {
        final Product1Factory product1Factory = new Product1Factory();
        final Component1 product1Component1 = product1Factory.getProductComponent1();
        final Component2 product1Component2 = product1Factory.getProductComponent2();

        final Product1Factory product2Factory = new Product1Factory();
        final Component1 product2Component1 = product2Factory.getProductComponent1();
        final Component2 product2Component2 = product2Factory.getProductComponent2();

    }
}
