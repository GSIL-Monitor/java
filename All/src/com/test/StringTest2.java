package com.test;

/**
 *
 */
public class StringTest2 {
	String str = new String("good");
	char[] ch = {'a', 'b', 'c'};

	public static void main(String[] args) {
		StringTest2 ex = new StringTest2();
		ex.change(ex.str, ex.ch);
		System.out.println(ex.str + " and ");
		System.out.println(ex.ch);
	}

	public void change(String str, char ch[]) {
		str = "test ok";
		ch[0] = 'g';
	}
}
