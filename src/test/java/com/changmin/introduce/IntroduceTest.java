package com.changmin.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class IntroduceTest {
    @Test
    public void introduce(){
        String configPath = "com/changmin/introduce/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)ctx.getBean("forumService");

        forumService.removeForum(120);
        forumService.removeTopic(102);

        Monitorable monitorable = (Monitorable)forumService;//强制性的将forumService转换为Monitor类型
        monitorable.setMonitorActive(true);

        forumService.removeForum(120);
        forumService.removeTopic(102);
    }
}
