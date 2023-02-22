package com.gupao.springbootdemo.controller.desingParttern.singleton.ofenum;

/**
 * @Classname EnumSingleton
 * @Description 枚举类的实例 SINGLETON 本身为单例，构造方法私有
 * @Date 2021/8/2 6:48 下午
 * @Creator naoling
 */
public enum EnumSingleton {
    SINGLETON;
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
