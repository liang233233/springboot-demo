package com.gupao.springbootdemo.controller.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hliang
 */
@RestController
public class MetaspaceController {
    List<Class<?>> list = new ArrayList<Class<?>>();


    /**
     * 方法区溢出
     *
     *  -XX:MetaspaceSize=50M -XX:MaxMetaspaceSize=50M
     *
     *
     *
     * Exception in thread "http-nio-8101-exec-1" java.lang.OutOfMemoryError: Metaspace
     *
     * @return
     */
    @GetMapping("/metaspace")
    public String nonheap() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaspaceController.TestObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
                    return arg3.invokeSuper(arg0, arg2);
                }
            });
            enhancer.create();
        }
    }

    public static class TestObject {
        private double a = 34.53;
        private Integer b = 9999999;
    }
}