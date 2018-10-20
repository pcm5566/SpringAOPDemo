package com.changmin.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ControlFlowAdvisorTest {
    @Test
    public void dynamicMethodAdvisorTest(){
        String configPath = "com/changmin/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter3");
        //Seller seller = (Seller)ctx.getBean("seller");
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);

        waiter.greetTo("Jones");
        waiter.serveTo("Jones");
        waiter.greetTo("Michael");
        waiter.serveTo("Michael");
        waiterDelegate.service("Scofield");
        //seller.greetTo("Michael");
    }
}
