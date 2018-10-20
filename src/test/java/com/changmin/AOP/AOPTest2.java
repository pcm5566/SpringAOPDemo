package com.changmin.AOP;

import com.changmin.proxy.CglibProxy;
import org.testng.annotations.Test;

public class AOPTest2 {
    @Test
    public void proxy(){
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(1200);
    }
}
