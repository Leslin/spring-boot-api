package com.app.driver.controller;


/**
 * Desc:多线程测试控制器
 * Author: dalin
 * Data: 2018/5/22
 * Time: 21:45
 */

public class ThreadController extends Thread {
    private Thread t;
    private String threadName;

    /**
     * 初始化
     * @param name
     */
    ThreadController(String name){
        threadName = name;
        System.out.println("Creating " +  threadName);
    }

    public void run(){
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
}
