package com.bo.login_demo.service.impl;

import com.bo.login_demo.entity.User;
import com.bo.login_demo.repository.UserRepository;
import com.bo.login_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
}
