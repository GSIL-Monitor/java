package com.test;

/**
 *
 */
public class StringTest {

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "he" + new String("llo");
		String str3 = "he" + "llo";
		String str4 = "hello";

		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

		System.out.println(str1 == str3);
		System.out.println(str1 == str4);

		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
	}





}
