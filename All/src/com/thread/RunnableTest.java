package com.thread;

public class RunnableTest implements Runnable {

    private final int id;

    public RunnableTest(int id) {
        this.id = id;
    }

    //实现Runnable接口必须重写其run方法 该 run() 方法将作为线程执行体
    public void run() {
        System.out.println("id " + id + " implements Runnable is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("id " + id + " implements Runnable finished running");
    }

    public static void main(String[] args) {
        //RunnableTest r1 = new RunnableTest();
        //Thread t1 = new Thread(r1); //将Runnable作为Thread类的参数，然后通过Thread的start方法来创建一个新线程
        //t1.start();

        //RunnableTest r2 = new RunnableTest();
        //Thread t2 = new Thread(r2);
        //t2.start();
    }
}
