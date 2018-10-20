package com.changmin.AOP;

public class PerformanceMonitor {
    //performanceRecord代表一个能够存放MethodPerformance类型的ThreadLocal对象。
    // 此时不论什么一个线程能够并发訪问这个变量，对它进行写入、读取操作，都是线程安全的。
    // 比方一个线程通过performanceRecord.set(“mp”);将数据写入ThreadLocal中，在不论什么一个地方，都能够通过performanceRecord.get();将值获取出来。
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();
    public static void begin(String method){
        System.out.println("begin monitor……");
        MethodPerformance mp = performanceRecord.get();
        if (mp == null){
            mp = new MethodPerformance(method);
            performanceRecord.set(mp);
        }
        else {
            mp.reset(method);
        }
    }
    public static void end(){
        System.out.println("end monitor……");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformanc();
    }
}
