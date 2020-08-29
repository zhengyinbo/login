package com.bo.login_demo.repository;

import com.bo.login_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserId(Long userId);

}
