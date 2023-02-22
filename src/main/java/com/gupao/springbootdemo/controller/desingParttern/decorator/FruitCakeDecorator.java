package com.gupao.springbootdemo.controller.desingParttern.decorator;

/**
 * @Classname FruitCakeDecorator
 * @Description TODO
 * @Date 2021/8/3 12:33 下午
 * @Creator naoling
 */
public class FruitCakeDecorator extends ConcreteCake {
    private Cake cake;

    @Override
    public String getName() {
        return cake.getName() + "【水果+1份】";
    }

    @Override
    public int getPrice() {
        return cake.getPrice() + 30;
    }

    public String getOriginalName() {
        return super.getName();
    }

    public int getOriginalPrice() {
        return super.getPrice();
    }

    public FruitCakeDecorator(Cake cake) {
        this.cake = cake;
    }

}
