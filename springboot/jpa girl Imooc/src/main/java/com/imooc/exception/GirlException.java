package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by 廖师兄
 * 2017-01-21 14:05
 */
//默认的Exception只接受message，为了接受code我们自己定义一个异常GirlException  还要写一个捕获异常的类ExceptionHandle
//spring只对抛出的RuntimeException异常进行事务回滚
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
