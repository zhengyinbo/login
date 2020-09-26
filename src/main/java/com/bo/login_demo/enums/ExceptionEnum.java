package com.bo.login_demo.enums;

import lombok.Getter;

/**
 * @Author bo
 * @DATE 2020/9/26
 **/

@Getter
public enum ExceptionEnum {

    EXCEPTION_1(1, "错误1"),
    ;

    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
