package com.aop;

public class Test {

	public static void main(String[] args) {
		com.aop.DogImp dogImp = new com.aop.DogImp();
		System.out.println(dogImp.getName());
		dogImp.getProperty();
	}
}
