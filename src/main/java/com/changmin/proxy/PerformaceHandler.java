package com.changmin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformaceHandler implements InvocationHandler {                      //实现InvocationHandler接口
    private Object target;                                                          //声明Object类对象target
    public PerformaceHandler(Object target){
        this.target = target;
    }              //设置PerformanceHandler类的target属性
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+ method.getName());
        Object obj = method.invoke(target, args);                                    //输出参数为args的target()方法的返回值，赋予obj
        PerformanceMonitor.end();
        return obj;
    }
}