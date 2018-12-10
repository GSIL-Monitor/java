package com.interface_;

public class SmartPhone implements IPlayGame {
    public void call() {
        System.out.println("SmartPhone Call");
    }

    public void sendMessage() {
        System.out.println("SmartPhone Send Message");
    }

    //实现接口就必须实现接口里面要求的方法
    @Override
    public void playGame() {
        System.out.println("SmartPhone Play Game");
    }


}
