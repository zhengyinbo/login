package com.bo.login_demo.service;

import com.bo.login_demo.entity.RolePermission;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface RolePermissionService {

    List<RolePermission> findByRoleId(Long roleId);

    RolePermission saveRolePermission(RolePermission rolePermission);

}
