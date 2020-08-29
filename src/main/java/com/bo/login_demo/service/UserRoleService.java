package com.bo.login_demo.service;

import com.bo.login_demo.entity.UserRole;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface UserRoleService {

    List<UserRole> findByUseId(Long userId);

    UserRole saveUserRole(UserRole userRole);

}
