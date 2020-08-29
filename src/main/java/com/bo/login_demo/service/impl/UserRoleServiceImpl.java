package com.bo.login_demo.service.impl;

import com.bo.login_demo.entity.UserRole;
import com.bo.login_demo.repository.UserRoleRepository;
import com.bo.login_demo.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/

@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository repository;

    @Override
    public List<UserRole> findByUseId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return repository.save(userRole);
    }
}
