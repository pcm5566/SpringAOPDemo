package com.changmin.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class BeforeAdviceTest {
    @Test
    public void before(){
        Waiter target = new NavieWaiter();//通过多态创建接口的对象
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();//创建ProxyFactory
        proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setOptimize(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);
        //Waiter类是子类，proxyFactory是父类对象
        Waiter proxy = (Waiter)proxyFactory.getProxy();
        proxy.greetTo("Michael");
        proxy.serveTo("Bruce");
    }
}
