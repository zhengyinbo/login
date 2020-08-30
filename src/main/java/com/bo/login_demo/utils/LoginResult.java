package com.bo.login_demo.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @Author bo
 * @DATE 2020-08-30
 **/

@Data
public class LoginResult {

    public static Object success(Object token){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "登陆成功");
        jsonObject.put("data", token);
        return jsonObject;
    }

    public static Object fail(Integer status, String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", status);
        jsonObject.put("msg", msg);
        return jsonObject;
    }

}
