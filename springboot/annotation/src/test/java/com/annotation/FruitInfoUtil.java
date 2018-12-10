package com.annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        Field[] fileds = clazz.getDeclaredFields();

        for (Field field : fileds) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                System.out.println(fruitName);

            }
        }
    }
}
