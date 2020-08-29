package com.bo.login_demo.service.impl;

import com.bo.login_demo.entity.Role;
import com.bo.login_demo.repository.RoleRepository;
import com.bo.login_demo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role findByRoleId(Long roleId) {
        return repository.findByRoleId(roleId);
    }

    @Override
    public Role saveRole(Role role) {
        return repository.save(role);
    }
}
