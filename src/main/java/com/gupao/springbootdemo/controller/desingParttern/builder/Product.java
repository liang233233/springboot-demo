package com.gupao.springbootdemo.controller.desingParttern.builder;

/**
 * @Classname Product
 * @Description TODO
 * @Date 2021/8/3 11:54 下午
 * @Creator naoling
 */
public class Product {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
