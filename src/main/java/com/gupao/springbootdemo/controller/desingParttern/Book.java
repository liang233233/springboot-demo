package com.gupao.springbootdemo.controller.desingParttern;

public class Book {

    public String lock(String str) {

        return "book---" + str;
    }


    public static void main(String[] args) {
        Book book = new Chinese();
        String lock = book.lock("11");
        System.out.println(lock);
    }

}

class Chinese extends Book {


    @Override
    public String lock(String str) {

        return "Chinese---" + str;
    }

    public String lock(String str, String str2) {

        return "Chinese---" + str + str2;
    }

}