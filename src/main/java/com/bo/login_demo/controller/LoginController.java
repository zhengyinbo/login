package com.bo.login_demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.login_demo.entity.Role;
import com.bo.login_demo.entity.User;
import com.bo.login_demo.entity.UserRole;
import com.bo.login_demo.service.RoleService;
import com.bo.login_demo.service.UserRoleService;
import com.bo.login_demo.service.UserService;
import com.bo.login_demo.utils.LoginResult;
import com.bo.login_demo.utils.Result;
import com.bo.login_demo.utils.ReturnResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/login")
    public Object login(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        SecurityUtils.getSubject().getSession().setTimeout(-1000l);//设置session失效时间：-1000l表示无限时长，默认为1800000表示30分钟 30*60*1000
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
            return LoginResult.success(subject.getSession().getId());//返回登录状态
        } catch (IncorrectCredentialsException e) {
            return LoginResult.fail(401,"密码错误");
        } catch (LockedAccountException e) {
            return LoginResult.fail(401,"登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            return LoginResult.fail(401,"该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/role")
    public Object getUserRole(){
        User user = userService.getUerInfo();
        List<UserRole> userRoles = userRoleService.findByUseId(user.getUserId());
        String[] roles = new String[userRoles.size()];
        for (int i=0;i<userRoles.size();i++){
            Role role = roleService.findByRoleId(userRoles.get(i).getRoleId());
            roles[i] = role.getRoleName();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roles", roles);
        jsonObject.put("userName", user.getUserName());
        jsonObject.put("userId", user.getUserId());
        return ReturnResult.success(jsonObject);
    }

    @RequestMapping("/unauth")
    public Object unauth(){
        return LoginResult.fail(1001, "未登录");
    }

    @PostMapping("/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return ReturnResult.success("成功退出登陆");
        }catch (Exception e){
            e.printStackTrace();
            System.out.printf(e.getLocalizedMessage());
            return ReturnResult.fail(401, "退出失败");
        }
    }

}
