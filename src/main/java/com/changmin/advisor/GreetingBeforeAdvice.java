package com.changmin.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method,Object[] args,Object obj) throws Throwable{
        System.out.println("类："+obj.getClass().getName()+"方法："+method.getName());
        String clientName = (String)args[0];
        System.out.println("How are you? Mr."+clientName);
    }
}
