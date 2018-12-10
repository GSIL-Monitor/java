package com.poker;

import java.util.Comparator;

public class Compare implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        String[] colors = {"方块", "梅花", "红桃", "黑桃"};
        String[] numbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int col1 = 0;
        int col2 = 0;
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (o1.number == numbers[i])
                num1 = i;
            if (o2.number == numbers[i])
                num2 = i;
            }

        if (num1 == num2){
            for (int i = 0; i < colors.length; i++) {
                if (o1.color == colors[i])
                    col1 = i;
                if (o2.color == colors[i])
                    col2 = i;
            }


            if (col1 > col2)
                return 1;
            else
                return -1;
        }else if (num1 > num2)
            return 1;
        else
            return -1;
    }
}
