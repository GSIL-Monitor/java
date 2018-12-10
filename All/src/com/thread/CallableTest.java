package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {
    //实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
    public Integer call() throws Exception {
        System.out.println("当前线程： " + Thread.currentThread().getName());
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*创建 Callable 实现类的实例ctt，使用 FutureTask 类来包装 Callable 对象ctt，
         该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。*/
        CallableTest ct = new CallableTest();
        FutureTask<Integer> ft = new FutureTask<>(ct);

        System.out.println("当前线程： " + Thread.currentThread().getName());

        //使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
        Thread t = new Thread(ft,"有返回值的新线程");
        t.start();

        //调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
        System.out.println("新线程的返回值："+ft.get());

    }
}
