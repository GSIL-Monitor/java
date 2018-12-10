package com.demo.util;

import java.util.Random;

public class KeyUtil {
	public static synchronized String genUniqueKey() {
		Random random = new Random();
		//毫秒
		System.currentTimeMillis();

		//生成6位随机数
		Integer number = random.nextInt(9000000) + 1000000;

		return System.currentTimeMillis() + String.valueOf(number);

	}
}
