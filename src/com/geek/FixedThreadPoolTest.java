package com.geek;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 */
public class FixedThreadPoolTest {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			FixedThreadPool.INSTANCE.execute(() -> System.out.println(Thread.currentThread().getName()));
		}
	}

	enum FixedThreadPool {
		INSTANCE;
		private ExecutorService executorService;

		FixedThreadPool() {
			executorService = Executors.newFixedThreadPool(10);
		}

		public void execute(Runnable runnable) {
			executorService.execute(runnable);
		}
	}

}
