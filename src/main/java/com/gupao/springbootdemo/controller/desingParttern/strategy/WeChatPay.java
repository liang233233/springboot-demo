package com.gupao.springbootdemo.controller.desingParttern.strategy;

/**
 * @Classname WeChatPay
 * @Description TODO
 * @Date 2021/8/3 6:24 下午
 * @Creator naoling
 */
public class WeChatPay implements Pay{
    @Override
    public String pay(PayMethod payMethod) {
        System.out.println("使用WeChatPay.pay");
        return null;
    }
}
