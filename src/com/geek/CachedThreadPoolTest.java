package com.geek;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 */
public class CachedThreadPoolTest {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			CachedThreadPool.INSTANCE.execute(() -> System.out.println(Thread.currentThread().getName()));
		}
	}

	enum CachedThreadPool {
		INSTANCE;
		private ExecutorService executorService;

		CachedThreadPool() {
			executorService = Executors.newCachedThreadPool();
		}

		public void execute(Runnable runnable) {
			executorService.execute(runnable);
		}
	}

}
