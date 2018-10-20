package com.changmin.introduce;

import com.changmin.proxy.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllerablePerformanceMonitor
        extends DelegatingIntroductionInterceptor
        implements Monitorable,Testable {
    //①定义一个ThreadLocal类型的变量MonitorStatusMap变量，用于保存性能监视开关状态。
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();
    public void setMonitorActive(boolean active){
        MonitorStatusMap.set(active);
    }
    //拦截方法
    public Object invoke(MethodInvocation mi) throws Throwable{
        Object obj = null;
        if (MonitorStatusMap.get()!=null && MonitorStatusMap.get()){
            PerformanceMonitor.begin(mi.getClass().getName()+"."+mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        }else {
            obj = super.invoke(mi);
        }
        return obj;
    }
    public void test(){
        System.out.println("测试中……");
    }

}
