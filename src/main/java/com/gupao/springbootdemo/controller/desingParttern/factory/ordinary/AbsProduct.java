package com.gupao.springbootdemo.controller.desingParttern.factory.ordinary;

/**
 * @Classname AbsProduct
 * @Description 抽象产品
 * @Date 2021/8/2 7:19 下午
 * @Creator naoling
 */
public abstract class AbsProduct {
    String name;
    String price;
    public abstract String getName();

    public abstract int getPrice();
}
