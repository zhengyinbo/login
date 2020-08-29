package com.bo.login_demo.service;

import com.bo.login_demo.entity.Role;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface RoleService {

    Role findByRoleId(Long roleId);

    Role saveRole(Role role);

}
