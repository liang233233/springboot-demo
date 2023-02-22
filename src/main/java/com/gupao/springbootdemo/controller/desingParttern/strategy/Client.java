package com.gupao.springbootdemo.controller.desingParttern.strategy;

/**
 * 策略模式
 *
 * 主动选择策略类型,
 *
 *
 */
public class Client {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.pay(PayMethod.ALI_PAY);
        customer.pay(PayMethod.WE_CHAT_PAY);
    }
}
