package com.bo.login_demo.handler;

import com.bo.login_demo.exception.MyException;
import com.bo.login_demo.utils.Result;
import com.bo.login_demo.utils.ReturnResult;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

/**
 * @Author bo
 * @DATE 2020/9/26
 **/

@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 捕获所有异常
     * 未指定的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result MyException(Exception e){
        System.out.println("MyException");
        System.out.println(e);
        System.out.println(e.getMessage());
        return ReturnResult.fail(400, e.getMessage());
    }

    /**
     * 参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result MyMethodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("MyMethodArgumentNotValidException");
        System.out.println(e.getMessage());
        System.out.println(e.getBindingResult());
        return ReturnResult.fail(400, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 方法异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result MyHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        System.out.println("HttpRequestMethodNotSupportedException");
        System.out.println(e.getLocalizedMessage());
        return ReturnResult.fail(400, e.getMessage());
    }

    /**
     * 参数校验异常
     * 非bean参数  @Validated，@NotNull...
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result MyConstraintViolationException(ConstraintViolationException e){
        System.out.println("MyConstraintViolationException");
        System.out.println(e.getMessage());
        return ReturnResult.fail(400, e.getMessage());
    }

    /**
     * 空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result MyNullPointerException(NullPointerException e){
        System.out.println("MyNullPointerException");
        System.out.println(e.getMessage());
        return ReturnResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Result MyHttpMessageNotReadableException(HttpMessageNotReadableException e){
        System.out.println("MyHttpMessageNotReadableException");
        System.out.println(e.getHttpInputMessage());
        System.out.println(e.getMessage());
        return ReturnResult.fail(400, e.getMessage());
    }

    /**
     * 角色异常
     */
    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseBody
    public Result MyUnauthenticatedException(UnauthenticatedException e){
        System.out.println("MyUnauthenticatedException");
        System.out.println(e.getLocalizedMessage());
        System.out.println(e.getMessage());
        return ReturnResult.fail(400, e.getMessage());
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Result MyUnauthorizedException(UnauthorizedException e){
        System.out.println("MyUnauthorizedException");
        System.out.println(e.getLocalizedMessage());
        return ReturnResult.fail(400, e.getMessage());
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result myIllegalArgumentException(MyException e){
        return ReturnResult.fail(400, e.getMessage());
    }


}
