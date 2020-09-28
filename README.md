# 基于 SpringBoot 与 shiro 的登录框架

## 1. 前后端分离项目，服务器基于token获取身份与权限

## 2. 五张基础表

  #### 1. 用户表（user）

  #### 2. 角色表（role）

  #### 3. 权限表（permission）

  #### 4. 用户-角色表（user-role）

  #### 5. 角色-权限表（role-permission）

## 3. 需要引入的依赖

 ```
 <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
 </dependency>
 <dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring</artifactId>
    <version>1.4.0</version>
 </dependency>
 ```

## 4. 其他

1. 需要在数据库中新增login表

```
create database login
```

2. 数据库密码默认为 123456，可在application.yml中修改。



## 5. 新增统一异常处理

```
    测试异常
    /user/create
    /user/list
```
   

