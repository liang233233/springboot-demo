package com.gupao.springbootdemo.controller.desingParttern.observer;

/**
 * 观察者模式
 */
public class Client {
    public static void main(String[] args) {
        final Student naoling = new Student("naoling", "0121");
//        naoling.uploadWork(new HomeWork());
        final Teacher huihui = new Teacher("huihui");
        final Teacher yiling = new Teacher("yiling");
        naoling.addObserver(huihui);
        naoling.addObserver(yiling);

        naoling.uploadWork(new HomeWork());
    }
}
