package com.gupao.springbootdemo.controller.desingParttern.decorator;

/**
 * 装饰器模式
 */
public class Client {
    public static void main(String[] args) {
        final ConcreteCake concreteCake = new ConcreteCake();
        System.out.println(concreteCake.getName());
        System.out.println(concreteCake.getPrice());

        final FruitCakeDecorator fruitCakeDecorator = new FruitCakeDecorator(concreteCake);
        System.out.println(fruitCakeDecorator.getName());
        System.out.println(fruitCakeDecorator.getPrice());

        final FruitCakeDecorator fruitCakeDecorator1 = new FruitCakeDecorator(fruitCakeDecorator);
        System.out.println(fruitCakeDecorator1.getName());
        System.out.println(fruitCakeDecorator1.getPrice());

        System.out.println("原始名词：" + fruitCakeDecorator1.getOriginalName());
        System.out.println("原价：" + fruitCakeDecorator1.getOriginalPrice());
    }
}
