package com.bo.login_demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/

@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long count;

    public Result(){}

}
