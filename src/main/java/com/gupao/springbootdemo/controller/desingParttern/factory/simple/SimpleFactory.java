package com.gupao.springbootdemo.controller.desingParttern.factory.simple;


import com.gupao.springbootdemo.model.Brand;

/**
 * @Classname SimpleFactory
 * @Description： 工厂模式的主要作用：创建对象，分离类的定义与对象的创建
 * 1、通过标签创建对象
 * 2、通过全类名创建对象
 * 3、通过类的反射类型创建对象
 * @Date 2021/8/2 7:07 下午
 * @Creator naoling
 */
public class SimpleFactory {

    public Brand createByFlag(String flag) {
        if ("product".equals(flag)) {
            return new Brand();
        }
        return null;
    }

    public Brand createByFullPath(String className) {
        if (!isValid(className)) {
            return null;
        }
        try {
            return (Brand) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Brand createByFullPath(Class<?> clazz) {
        if (!isValid(clazz)) {
            return null;
        }
        try {
            return (Brand) Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isValid(Class<?> clazz) {
        return false;
    }

    private boolean isValid(String className) {
        return false;
    }
}
