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

	/* 使用单例模式 */
	public enum FixedThreadPool {
		INSTANCE;
		private ExecutorService executorService;

		/* 初始化一个固定大小的线程池 */
		FixedThreadPool() {
			executorService = Executors.newFixedThreadPool(10);
		}

		/* 执行一个Runnable */
		public void execute(Runnable runnable) {
			executorService.execute(runnable);
		}

		/* 关闭线程池操作，用于main方法的退出 */
		public void shutdown() {
			boolean foo = executorService.isShutdown();
			if (!foo) {
				executorService.shutdown();
			}
			System.out.println("线程池已关闭");
		}
	}

}
