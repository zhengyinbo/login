package com.bo.login_demo.exception;

import com.bo.login_demo.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @Author bo
 * @DATE 2020/9/26
 **/

@Getter
public class MyException extends RuntimeException{

    private Integer code;

    public MyException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public MyException(Integer code, String msg){
        super(msg);
        this.code = code;
    }

}
