package com.xinput.bleach.util;

import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * 加密算法
 */
public class SecureUtils {

    /**
     * MD5 签名字符串
     *
     * @param text 需要签名的字符串,默认UTF-8
     */
    public static String MD5(String text) throws UnsupportedEncodingException {
        return MD5(text, "utf-8");
    }

    /**
     * MD5 签名字符串
     *
     * @param text        需要签名的字符串
     * @param charsetName 编码格式(默认UTF-8)
     */
    public static String MD5(String text, String charsetName) throws UnsupportedEncodingException {
        if (StringUtils.isNullOrEmpty(charsetName)) {
            charsetName = "utf-8";
        }
        return DigestUtils.md5Hex(text.getBytes(charsetName));
    }

    /**
     * 生成 HMACSHA256
     *
     * @param data 待处理数据
     * @param key  密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        return HMACSHA256(data, key, "UTF-8");
    }

    /**
     * 生成 HMACSHA256
     *
     * @param data 待处理数据
     * @param key  密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key, String charsetName) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(charsetName), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes(charsetName));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 验证MD5签名字符串
     *
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @return 签名结果
     */
    public static boolean verifyMD5(String text, String sign) throws UnsupportedEncodingException {
        return verifyMD5(text, sign, "utf-8");
    }

    /**
     * 验证MD5签名字符串
     *
     * @param text        需要签名的字符串
     * @param sign        签名结果
     * @param charsetName 编码格式
     * @return 签名结果
     */
    public static boolean verifyMD5(String text, String sign, String charsetName) throws UnsupportedEncodingException {
        if (StringUtils.isNullOrEmpty(charsetName)) {
            charsetName = "utf-8";
        }

        if (StringUtils.equalsIgnoreCase(sign, MD5(text, charsetName))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证HMACSHA256签名字符串
     *
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @return 签名结果
     */
    public static boolean verifyHMACSHA256(String text, String sign) throws Exception {
        return verifyHMACSHA256(text, sign, "utf-8");
    }

    /**
     * 验证HMACSHA256签名字符串
     *
     * @param text        需要签名的字符串
     * @param sign        签名结果
     * @param charsetName 编码格式
     * @return 签名结果
     */
    public static boolean verifyHMACSHA256(String text, String sign, String charsetName) throws Exception {
        if (StringUtils.isNullOrEmpty(charsetName)) {
            charsetName = "utf-8";
        }

        if (StringUtils.equalsIgnoreCase(sign, HMACSHA256(text, charsetName))) {
            return true;
        } else {
            return false;
        }
    }

}
