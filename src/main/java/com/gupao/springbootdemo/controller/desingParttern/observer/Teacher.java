package com.gupao.springbootdemo.controller.desingParttern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Classname Teather
 * @Description TODO
 * @Date 2021/8/4 12:23 上午
 * @Creator naoling
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        final Student o1 = (Student) o;
        final HomeWork arg1 = (HomeWork) arg;
        System.out.println(name+"：【=========您刚收到一条消息=========】");
        System.out.println("name: " + o1.getName() + ", id: " + o1.getId());
        System.out.println("work content：" + arg1.getContent() + ", signId：" + arg1.getSignId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
