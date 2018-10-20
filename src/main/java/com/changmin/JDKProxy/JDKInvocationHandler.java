package com.changmin.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDKInvocationHandler implements InvocationHandler {
    private ProductService target;
    public Object getInstance(ProductService target){
        this.target = target;
        Class clazz = this.target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String currentTime = simpleDateFormat.format(new Date());
        System.out.println("【"+currentTime+"】添加了一款产品");
        return method.invoke(this.target,args);
    }
}
