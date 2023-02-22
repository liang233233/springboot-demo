package com.gupao.springbootdemo.controller.desingParttern.strategy;

/**
 * @Classname Pay
 * @Description TODO
 * @Date 2021/8/3 6:18 下午
 * @Creator naoling
 */
public interface Pay {

    String pay(PayMethod payMethod);
}
