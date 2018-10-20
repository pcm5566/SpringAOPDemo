package com.changmin.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    public boolean matches(Method method,Class clazz){
        return "greetTo".equals(method.getName());
    }
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Seller.class.isAssignableFrom(clazz);
            }
        };
    }
}
