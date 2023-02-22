package com.gupao.springbootdemo.controller.desingParttern.strategy;

/**
 * @Classname AliPay
 * @Description TODO
 * @Date 2021/8/3 6:25 下午
 * @Creator naoling
 */
public class AliPay implements Pay {
    @Override
    public String pay(PayMethod payMethod) {
        System.out.println("使用AliPay.pay");
        return null;
    }
}
