package com.geek.test;

import com.geek.FixedThreadPoolTest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.stream.IntStream;

/**
 * 仅仅是测试下载图片
 */
public class TestDownloadImages {
	public static void main(String[] args) {
		String preUrl = "http://img.infinitynewtab.com/wallpaper/";
		IntStream.range(200, 400).forEach(o -> FixedThreadPoolTest.FixedThreadPool.INSTANCE.execute(() -> {
			try {
				URL url = new URL(preUrl + o + ".jpg");
				File file = new File("D:/image/" + o + ".jpg");
				FileUtils.copyURLToFile(url, file);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}));
		FixedThreadPoolTest.FixedThreadPool.INSTANCE.shutdown();
	}
}
