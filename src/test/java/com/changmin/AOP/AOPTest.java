package com.changmin.AOP;

import org.testng.annotations.Test;

public class AOPTest {
    @Test
    public void proxy(){
        ForumService forumService = new ForumServiceImpl();
        forumService.removeTopic(1200);
    }
}
