package com.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 */
public class ThreadPoolTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//创建线程池  设置最大线程数量是3
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// main函数结束，但是程序并没有结束，要等到所有的Thread都退出，所以要等到这10个任务都做完才能退出
		// Future<?> 用来保存线程运行结果
		List<Future<?>> taskResults = new LinkedList<>();

		//派发10个任务
		for (int i = 0; i <10 ; i++) {
			taskResults.add(executor.submit(new RunnableTest(i)));
		}
		System.out.println("10 tasks dispatched successfully.");

		//等待10个任务完成并返回结果
		for (Future<?> taskResult : taskResults) {
			//get（）为等待task结束 一旦task结束就会返回RunnableTest（）的返回值 null
			taskResult.get();
		}

		//10个任务都已经完成
		System.out.println("All tasks finished");
		//关闭 shutdown（）自己也可以起到等待task结束的功能
		executor.shutdown();
	}
}
