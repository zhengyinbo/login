package com.bo.login_demo.service;

import com.bo.login_demo.entity.Permission;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface PermissionService {

    Permission findByPermissionId(Long permissionId);

    Permission savePermission(Permission permission);

}
