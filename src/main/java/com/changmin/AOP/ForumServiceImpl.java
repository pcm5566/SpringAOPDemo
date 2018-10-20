package com.changmin.AOP;

public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId){
        PerformanceMonitor.begin("com.changmin.AOP.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录"+topicId);
        try {
            Thread.currentThread().sleep(400);
        }catch (Exception e){
            e.printStackTrace();
        }
        PerformanceMonitor.end();
    }
}
