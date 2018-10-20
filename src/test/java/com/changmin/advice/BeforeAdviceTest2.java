package com.changmin.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class BeforeAdviceTest2 {
    @Test
    public void advice(){
        String configPath = "com/changmin/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("Michael");
        waiter.serveTo("Scofield");
    }
}
