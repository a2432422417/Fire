
package com.yskcoder.fire.core.util;

import java.util.*;

/**
* @Description: Fire工具类
* @Author:      yushunkun
* @CreateDate:  2018/7/24 15:53
*/
public class ToolUtil {


    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}