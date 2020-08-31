
##数据库

CREATE DATABASE login_demo ;

USE login_demo;

##用户表
CREATE TABLE USER(
`user_id` BIGINT NOT NULL AUTO_INCREMENT,
`user_name` VARCHAR(32) NOT NULL COMMENT '用户名',
`password` VARCHAR(64) NOT NULL COMMENT '密码'
PRIMARY KEY (`user_id`),
UNIQUE KEY (`user_name`)
);

##角色表
CREATE TABLE ROLE(
`role_id` BIGINT NOT NULL AUTO_INCREMENT,
`role_name` VARCHAR(32) NOT NULL COMMENT '角色名',
PRIMARY KEY (`role_id`),
UNIQUE KEY (`role_name`)
);

##权限表
CREATE TABLE permissino(
`permission_id` BIGINT NOT NULL AUTO_INCREMENT,
`permission_name` VARCHAR(32) NOT NULL COMMENT '',
PRIMARY KEY (`permission_id`),
UNIQUE KEY (`permission_name`)
);

##用户-角色表
CREATE TABLE user_role(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`user_id` BIGINT NOT NULL,
`role_id` BIGINT NOT NULL,
PRIMARY KEY (`id`)
);

##角色权限表
CREATE TABLE role_permission(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`role_id` BIGINT NOT NULL,
`permission_id` BIGINT NOT NULL,
PRIMARY KEY (`id`)
);










