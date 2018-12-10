package com.exception;

public class Main {

    public static void main(String[] args) {
        BankCheck bc = new BankCheck();
        bc.check();
        try {
            bc.withdrow(8000);
        } catch (MyException e) {
            System.out.println("you are short $" + e.getAmount());
            e.printStackTrace();
        }

    }
}
