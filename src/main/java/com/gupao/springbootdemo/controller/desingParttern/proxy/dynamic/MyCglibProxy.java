package com.gupao.springbootdemo.controller.desingParttern.proxy.dynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname MyCglibProxy
 * @Description
 *
 * cglib实现思路
 * 生成一个目标类的代理子类，子类中包括目标类的所有方法，以及一一对应的代理方法。
 *
 * 代理子类初始化时 主要装饰以下静态成员引用
 * 1、方法拦截器 MethodInterceptor
 * 2、目标类真实方法引用 Method
 * 3、目标类代理方法引用 MethodProxy
 *
 * 代理实例调用时，在代理方法中调用拦截器的intercept 方法
 *
 * 最后进入自定义拦截器实现类的intercept方法，通过 methodProxy.invokeSuper(o, objects) 可以索引到目标真实方法进行调用
 *
 * @Date 2021/8/3 12:55 下午
 * @Creator naoling
 */
public class MyCglibProxy implements MethodInterceptor {

    private Object target;

    public MyCglibProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());// 设置父类
        enhancer.setCallback(this);// 设置当前拦截器实例
        return enhancer.create();// 创建代理子类实例
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        final Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("MyCglibProxy.before");
    }

    private void after() {
        System.out.println("MyCglibProxy.after");
    }
}
