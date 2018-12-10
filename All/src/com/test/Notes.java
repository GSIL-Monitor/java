package com.test;

/**
 *
 */
public class Notes {


	public static void main(String[] args) {
		Notes a = new Notes();
		a.test0();
		a.test1();
		a.test2();
		a.test3();
	}

	/**
	 * 比较包装类
	 */
	public void test0() {
		Integer i1 = 100;
		Integer i2 = 100;
		Integer i3 = 200;
		Integer i4 = 200;

		System.out.println(i1==i2);
		System.out.println(i3==i4);
	}

	/**
	 * 比较数值
	 */
	public void test1() {
		int a = 3;
		int b = 3;

		if (a == b) {
			System.out.println("a==b");
		} else {
			System.out.println("a!=b");
		}
	}

	/**
	 * 比较字符串
	 */
	public void test2() {
		String  a = "test";
		String  b = "test";

		if (a == b) {
			System.out.println("a==b");
		} else {
			System.out.println("a!=b");
		}
	}

	public void test3() {
		String  a = "test";
		String  b = "test";

		if (a.equals(b)) {
			System.out.println("a.equals(b)");
		} else {
			System.out.println("a==b");
		}
	}
}
