package com.braisedpanda.mypractices.commons.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-16 11:53
 **/
public class MD5Utils {
    private final String SecurityKey = "88888888";

    public static String encrypt(String str){
        String str1 = DigestUtils.md5Hex(str);
        return str1;
    }


}
