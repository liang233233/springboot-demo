package com.gupao.springbootdemo.controller.desingParttern.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname Customer
 * @Description TODO
 * @Date 2021/8/3 6:27 下午
 * @Creator naoling
 */
public class Customer {

    private static final Map<PayMethod,Pay> PAY_METHOD_PAY_MAP = new ConcurrentHashMap<>();
    static {
        PAY_METHOD_PAY_MAP.put(PayMethod.ALI_PAY,new AliPay());
        PAY_METHOD_PAY_MAP.put(PayMethod.WE_CHAT_PAY,new WeChatPay());
    }

    public String pay(PayMethod payMethod){
        return PAY_METHOD_PAY_MAP.get(payMethod).pay(payMethod);
    }
}
