package com.test;

import org.junit.Test;
import org.springframework.util.DigestUtils;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

public class testMD5 {
    @Test
    public void testmd5() throws NoSuchAlgorithmException {
        String username = "abc";
        String password = "123";
        String web_key = "2745";
        String expire_time = "7";
//        MessageDigest md = MessageDigest.getInstance("MD5");
        String original_string = username+expire_time+web_key+password;
        MessageDigest md = MessageDigest.getInstance("MD5");//获取MD5实例
        md.update(original_string.getBytes());//此处传入要加密的byte类型值
        byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值
        String result="";
        for (int i=0; i<digest.length;i++){
            result+=Integer.toHexString((0x000000ff & digest[i]) | 0xffffff00).substring(6);
        }
        System.out.println(result);
    }
}
