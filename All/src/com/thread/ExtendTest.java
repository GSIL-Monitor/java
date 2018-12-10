package com.thread;

public class ExtendTest extends Thread {
    //继承Thread类必须重写run()方法 该 run() 方法将作为线程执行体
    public void run() {
        System.out.println("Extends Thread is running");
    }

    public static void main(String[] args) {
        ExtendTest t1 = new ExtendTest(); //创建线程对象，然后通过start()方法去启动线程
        t1.start();

        ExtendTest t2 = new ExtendTest();
        t2.start();
    }
}
