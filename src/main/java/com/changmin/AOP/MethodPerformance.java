package com.changmin.AOP;

public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;
    public MethodPerformance(String serviceMethod){
        reset(serviceMethod);
    }
    public void reset(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }
    public void printPerformanc(){
        end = System.currentTimeMillis();
        long escape = end - begin;
        System.out.println(serviceMethod+"花费"+escape+"毫秒。");
    }
}
