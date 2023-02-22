package com.gupao.springbootdemo.controller.desingParttern.builder;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2021/8/3 11:57 下午
 * @Creator naoling
 */
public class Client {
    public static void main(String[] args) {
        final ProductBuilder productBuilder = new ProductBuilder();
        productBuilder.setName("电脑").setPrice(9000);
        final Product build = productBuilder.build();
        System.out.println(build.getName());
        System.out.println(build.getPrice());
    }
}
