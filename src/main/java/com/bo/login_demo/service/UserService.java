package com.bo.login_demo.service;

import com.bo.login_demo.entity.User;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface UserService {

    User findByUserId(Long userId);

    User findByUserName(String userName);

    User getUerInfo();

    User saveUser(User user);

}
