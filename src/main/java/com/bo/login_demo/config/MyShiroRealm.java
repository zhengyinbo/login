package com.bo.login_demo.config;

import com.bo.login_demo.entity.*;
import com.bo.login_demo.service.*;
import com.bo.login_demo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020-08-30
 **/

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findByUserName(userName);
        List<UserRole> userRoles = userRoleService.findByUseId(user.getUserId());
        for (int i=0;i<userRoles.size();i++) {
            Role role = roleService.findByRoleId(userRoles.get(i).getRoleId());
            authorizationInfo.addRole(role.getRoleName());

            List<RolePermission> rolePermissions = rolePermissionService.findByRoleId(role.getRoleId());
            for (int j = 0; j < rolePermissions.size(); i++) {
                Permission permission = permissionService.findByPermissionId(rolePermissions.get(j).getPermissionId());
                authorizationInfo.addStringPermission(permission.getPermissionName());
            }
        }
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userService.findByUserName(userName);
        if (userName == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(),
                user.getPassword(),
                ByteSource.Util.bytes(Constant.PASSWORD_SALT),
                getName()
        );

        return authenticationInfo;
    }
}
