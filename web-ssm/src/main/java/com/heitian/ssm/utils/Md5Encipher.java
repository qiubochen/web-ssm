package com.heitian.ssm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encipher {
    public String encodeString(String str) throws NoSuchAlgorithmException {

        MessageDigest md5 =MessageDigest.getInstance("MD5");
        byte[] cipherData = md5.digest(str.getBytes());
        StringBuilder builder=new StringBuilder();
        for(byte cipher:cipherData){
           String toHexStr=Integer.toHexString(cipher&0xff);
           builder.append(toHexStr.length()==1?"0"+toHexStr:toHexStr);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
