package com.bo.login_demo.service.impl;

import com.bo.login_demo.entity.RolePermission;
import com.bo.login_demo.repository.RolePermissionRepository;
import com.bo.login_demo.service.RolePermissionService;
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
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionRepository repository;

    @Override
    public List<RolePermission> findByRoleId(Long roleId) {
        return repository.findByRoleId(roleId);
    }

    @Override
    public RolePermission saveRolePermission(RolePermission rolePermission) {
        return repository.save(rolePermission);
    }
}
