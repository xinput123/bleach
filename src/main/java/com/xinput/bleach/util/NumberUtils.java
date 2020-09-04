package com.xinput.bleach.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xinput
 * @date 2020-08-03 15:13
 */
public class NumberUtils {

    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");

    /**
     * 判断一个字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            //异常 说明包含非数字。
            return false;
        }

        // matcher是全匹配
        Matcher isNum = NUMBER_PATTERN.matcher(bigStr);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
