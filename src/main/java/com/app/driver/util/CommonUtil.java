package com.app.driver.util;

import java.util.Random;

/**
 * Desc:
 * Author: dalin
 * Data: 2018/5/10
 * Time: 15:48
 */
public class CommonUtil {
    /* *
     * @Description 获取指定位数的随机数
     * @Param [length]
     * @Return java.lang.String
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789QWERTYUIOPLKJHGFDSAZXCVBNM";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
