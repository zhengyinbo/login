package com.bo.login_demo.repository;

import com.bo.login_demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Long userId);

}
