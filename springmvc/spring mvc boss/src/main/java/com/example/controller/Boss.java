package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;

public class Boss {

	//属性中的 @Autowired
	@Autowired
	private Speak speak;

	//Setter 方法中的 @Autowired
	/*@Autowired
	public void setSpeak(Speak speak) {
		this.speak = speak;
	}*/

	public Speak getSpeak() {
		return speak;
	}

	public void speaking() {
		speak.saying();
	}
}
