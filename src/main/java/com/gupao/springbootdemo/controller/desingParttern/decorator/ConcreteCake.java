package com.gupao.springbootdemo.controller.desingParttern.decorator;

/**
 * @Classname ConcreteCake
 * @Description TODO
 * @Date 2021/8/3 12:34 下午
 * @Creator naoling
 */
public class ConcreteCake implements Cake {

    @Override
    public String getName() {
        return "普通蛋糕";
    }

    @Override
    public int getPrice() {
        return 100;
    }
}
