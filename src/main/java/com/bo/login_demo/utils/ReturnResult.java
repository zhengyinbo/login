package com.bo.login_demo.utils;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public class ReturnResult {

    public ReturnResult(){}

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return new ReturnResult().success(null);
    }

    public static Result success(Object object, Long count){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        result.setCount(count);
        return result;
    }

    public static Result fail(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

}
