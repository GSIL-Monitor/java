package com.test;

import java.util.Scanner;

/**
 *
 */
public class StringReverse2 {

	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		while(in.hasNext()){
			//next()是遇到空格；nextLine()是遇到回车
			String line=in.nextLine();
			StringBuilder sb=new StringBuilder(line);
			sb.reverse();

			System.out.println(sb.toString());
		}
	}

}
