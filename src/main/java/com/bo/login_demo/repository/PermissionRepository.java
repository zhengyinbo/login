package com.bo.login_demo.repository;

import com.bo.login_demo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByPermissionId(Long permissionId);

}
