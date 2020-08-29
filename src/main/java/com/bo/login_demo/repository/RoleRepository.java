package com.bo.login_demo.repository;

import com.bo.login_demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleId(Long roleId);

}
