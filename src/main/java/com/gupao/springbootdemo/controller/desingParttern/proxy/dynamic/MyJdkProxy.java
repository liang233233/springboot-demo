package com.gupao.springbootdemo.controller.desingParttern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname MyJdkProxy
 * @Description
 *
 * jdk动态代理原理
 * 1. 生成了实现类目标类所有接口的 $Proxy0 代理类，并继承了Proxy
 * 2. 在<init>初始化时 将 InvocationHandler 引用挂在 父类 Proxy 成员中
 * 3. 在代理实例调用时，实现的所有目标方法中，都调用类 super.h.invoke()
 * 4. 即回调到自定义 InvocationHandler 实现类的invoke方法中
 *
 * @Date 2021/8/3 12:55 下午
 * @Creator naoling
 */
public class MyJdkProxy implements InvocationHandler {

    private Object target;

    public MyJdkProxy(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }



    private void before() {
        System.out.println("MyJdkProxy.before");
    }

    private void after() {
        System.out.println("MyJdkProxy.after");
    }


}
