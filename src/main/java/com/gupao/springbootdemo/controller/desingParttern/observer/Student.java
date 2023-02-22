package com.gupao.springbootdemo.controller.desingParttern.observer;


import java.util.Observable;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2021/8/4 12:10 上午
 * @Creator naoling
 */
public class Student extends Observable {
    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void uploadWork(HomeWork homeWork) {
        System.out.println(name + ": Student.uploadWork");
        homeWork.setSignId(id);
        setChanged();
        notifyObservers(homeWork);
    }
}
