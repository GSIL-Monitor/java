package com.annotation;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color {
        BULE, RED, GREEN
    };

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}