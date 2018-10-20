package com.changmin.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();
    static {
        specialClientList.add("Michael");
        specialClientList.add("Scofield");
    }
    public ClassFilter classFilter(){
        return new ClassFilter(){
            public boolean matches(Class clazz){
                System.out.println("调用getClassFilter()对"+clazz.getName()+"做静态检查");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
    /*Spring在创建代理织入切面时，对目标类中的所有方法进行静态切点检查；
    在生成织入切面的代理对象后，第一次调用代理类的每一个方法时都会进行一次静态切点检查；
    如果本次检查
    */
    public boolean matches(Method method, Class clazz){
        System.out.println("调用Method.matches()"+clazz.getName()+"."+method.getName()+"做静态检查。");
        return "greetTo".equals(method.getName());
    }
    public boolean matches(Method method,Class clazz,Object[] args){
        System.out.println("调用Method.matches()"+clazz.getName()+"."+method.getName()+"做动态检查。");
        String clientName = (String)args[0];
        return specialClientList.contains(clientName);
    }
}
