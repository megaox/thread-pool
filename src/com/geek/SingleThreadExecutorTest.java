package com.geek;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行
 */
public class SingleThreadExecutorTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			final int j = i;
			SingleThreadExecutor.INSTANCE.execute(() -> {
				System.out.println(j);
				System.out.println(Thread.currentThread().getName());
			});
		}
	}

	enum SingleThreadExecutor {
		INSTANCE;
		private ExecutorService executorService;

		SingleThreadExecutor() {
			executorService = Executors.newSingleThreadExecutor();
		}

		public void execute(Runnable runnable) {
			executorService.execute(runnable);
		}
	}

}
