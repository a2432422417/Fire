package com.yskcoder.fire.core.shiro;

import com.yskcoder.fire.core.util.ToolUtil;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import org.apache.shiro.util.ByteSource;


public class ShiroUtil {

    /**
     * 加密方式
     */
    public final static String algorithmName = "SHA-512";

    /**
     * 循环次数
     */
    public final static int iterations = 1024;

    /**
     * shiro加密方式
     * @param credentials
     * @param saltSource
     * @return
     */
    public static String sha512(String credentials, String saltSource) {
        ByteSource salt = new Sha512Hash(saltSource);
        return new SimpleHash(algorithmName, credentials, salt, iterations).toString();
    }

    /**
     * 获取随机盐值
     * @param length
     * @return
     */
    public static String getRandomSalt(int length) {
        return ToolUtil.getRandomString(length);
    }




}
