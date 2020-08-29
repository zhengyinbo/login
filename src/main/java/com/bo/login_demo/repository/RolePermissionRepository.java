package com.bo.login_demo.repository;

import com.bo.login_demo.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    List<RolePermission> findByRoleId(Long roleId);

}
