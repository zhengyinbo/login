package com.bo.login_demo.service.impl;

import com.bo.login_demo.entity.Permission;
import com.bo.login_demo.repository.PermissionRepository;
import com.bo.login_demo.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository repository;

    @Override
    public Permission findByPermissionId(Long permissionId) {
        return repository.findByPermissionId(permissionId);
    }

    @Override
    public Permission savePermission(Permission permission) {
        return repository.save(permission);
    }
}
