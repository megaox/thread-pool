package com.geek;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，支持定时及周期性任务执行
 */
public class ScheduledThreadPoolTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			ScheduledThreadPool.INSTANCE.execute(() -> System.out.println(Thread.currentThread().getName()));
		}
	}

	enum ScheduledThreadPool {
		INSTANCE;
		private ScheduledExecutorService scheduledExecutorService;

		ScheduledThreadPool() {
			scheduledExecutorService = Executors.newScheduledThreadPool(10);
		}

		public void execute(Runnable runnable) {
			scheduledExecutorService.schedule(runnable, 5, TimeUnit.SECONDS);
		}
	}

}
