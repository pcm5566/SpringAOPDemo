package com.changmin.advice;

public class NavieWaiter implements Waiter{
    public void greetTo(String name){
        System.out.println("greet to:"+name);
    }
    public void serveTo(String name){
        System.out.println("serving to:"+name);
    }
}
