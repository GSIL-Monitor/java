package com.imooc.enums;

/**
 * Created by 廖师兄
 * 2017-01-21 14:23
 */

//定义枚举为了统一管理code和message    写代码要统一维护
public enum ResultEnum {
    //定义枚举方法，需要配合构造函数，参数保持一致
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),

    ;

    private Integer code;
    private String msg;

    //构造方法是必须的，参数和前面的枚举方法保持一致
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
