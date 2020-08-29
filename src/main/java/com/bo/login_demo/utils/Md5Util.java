package com.bo.login_demo.utils;

/**
 * @Author bo
 * @DATE 2020/8/29
 **/

import org.apache.shiro.crypto.hash.Md5Hash;


public class Md5Util {

    public static String pwdEncr(String password){
        Md5Hash md5Hash = new Md5Hash(password, Constant.PASSWORD_SALT);
        return md5Hash.toString();
    }

}
