package com.test;

/**
 *
 */
public class StringReverse1 {

	public static void main(String[] args) {
		String str = "I love Java";
		StringReverse1 sr = new StringReverse1();
		//System.out.println(sr.swapWords(str));

	}


	public void swapUtil(char[] arr, int begin, int end) {
		while(begin < end) {
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
	}

	/**
	 * 单词反转
	 */
	public String swapWords1(String str) {
		//将字符串对象中的字符转换为一个字符数组
		char[] arr = str.toCharArray();
		swapUtil(arr, 0, arr.length - 1);
		int begin = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == ' ') {
				swapUtil(arr, begin, i - 1);
				begin = i + 1;
			}
		}

		return new String(arr);
	}

	/**
	 * 使用StringBuilder对象实现反转
	 */
	public String swap2(String str) {
		StringBuilder sb=new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}


}
