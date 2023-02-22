package com.gupao.springbootdemo.controller.desingParttern.builder;

/**
 * @Classname Builder
 * @Description TODO
 * @Date 2021/8/3 11:54 下午
 * @Creator naoling
 */
public class ProductBuilder {
    private Product product = new Product();

    public ProductBuilder setName(String name) {
        this.product.setName(name);
        return this;
    }

    public ProductBuilder setPrice(int price) {
        this.product.setPrice(price);
        return this;
    }

    public Product build(){
        return product;
    }
}
