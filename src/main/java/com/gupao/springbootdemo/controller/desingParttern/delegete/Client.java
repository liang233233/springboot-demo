package com.gupao.springbootdemo.controller.desingParttern.delegete;

/**
 * 委派模式
 *
 *  根据 code 把业务交给不同的实现类做
 *
 *  登录场景
 *
 *
 */
public class Client {
    public static void main(String[] args) {
        final Boss boss = new Boss();
        Hr hr = (Hr)boss.request("hiring");
        hr.hiring();
        Coder coder = (Coder)boss.request("coding");
        coder.coding();
    }
}
