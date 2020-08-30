package com.bo.login_demo.init;

import com.bo.login_demo.entity.Role;
import com.bo.login_demo.entity.User;
import com.bo.login_demo.entity.UserRole;
import com.bo.login_demo.service.RoleService;
import com.bo.login_demo.service.UserRoleService;
import com.bo.login_demo.service.UserService;
import com.bo.login_demo.utils.Md5Util;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.Transient;

/**
 * 项目初始化
 * @Author bo
 * @DATE 2020-08-30
 **/

@Component
public class Init implements InitializingBean {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    @Transient
    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(userService.findByUserName("admin"))){

            User user = new User();
            user.setUserId(1L);
            user.setUserName("admin");
            user.setPassword(Md5Util.pwdEncr("123456"));
            userService.saveUser(user);

            User user1 = new User();
            user1.setUserId(2L);
            user1.setUserName("user1");
            user1.setPassword(Md5Util.pwdEncr("123456"));
            userService.saveUser(user1);

            Role admin = new Role();
            admin.setRoleId(1L);
            admin.setRoleName("admin");
            roleService.saveRole(admin);

            Role role = new Role();
            role.setRoleId(2L);
            role.setRoleName("user");
            roleService.saveRole(role);

            UserRole adminRole = new UserRole();
            adminRole.setRoleId(1L);
            adminRole.setUserId(1L);
            userRoleService.saveUserRole(adminRole);

            UserRole userRole = new UserRole();
            userRole.setRoleId(2L);
            userRole.setUserId(2L);
            userRoleService.saveUserRole(userRole);

        }
    }
}
