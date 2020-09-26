package com.bo.login_demo.controller;

import com.bo.login_demo.utils.Result;
import com.bo.login_demo.utils.ReturnResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Author bo
 * @DATE 2020/9/26
 **/

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @PostMapping("/create")
    public void createUser(@NotNull(message = "用户名不能为空") String userName,
                             @NotNull(message = "密码不能为空") String password){
        //todo
    }

}
