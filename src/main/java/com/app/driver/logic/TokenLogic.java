package com.app.driver.logic;

import com.app.driver.util.MD5Util;

import java.util.Map;
import java.util.TreeMap;

/**
 * Desc:token验证等操作
 * Author: dalin
 * Data: 2018/5/21
 * Time: 11:39
 */
public class TokenLogic {

    /**
     * 验证登录密码是否正确
     * @param password
     * @param uservalue
     * @param pwd
     * @return
     */
    public static Boolean checkPassword(String password,String uservalue,String pwd){

        String getPassword = MD5Util.md5(pwd+uservalue);
        if (password == getPassword){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 验证签名是否正确
     * @return
     */
    public static Boolean checkSign(Map<String,String> params,String appsercet){
        //先验证签名
        String sign = params.get("sign");  //原始签名
        params.remove("sign");        //去除签名字段
        Map<String,String> getParams = new TreeMap<>(params);
        String makeSign = makeSign(getParams,appsercet);
        if(sign == makeSign){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 生成签名进行对比
     * @param getParams
     * @param appsercet
     * @return
     */
    public static String makeSign(Map<String,String> getParams,String appsercet){
        return "";
    }
}
