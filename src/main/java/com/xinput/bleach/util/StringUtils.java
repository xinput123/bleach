package com.xinput.bleach.util;


import com.xinput.bleach.annotation.Remark;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    @Remark("点.")
    public static final String POINT = ".";

    @Remark("与字符串")
    public static final String SEPARATOR = "&";

    @Remark("逗号")
    public static final String COMMA = ",";

    @Remark("冒号")
    public static final String COLON = ":";

    @Remark("分号")
    public static final String SEMICOLON = ";";

    @Remark("斜杠")
    public static final String SLASH = "/";

    @Remark("制表符")
    public static final char TAB = '\t';

    @Remark("手机号长度")
    public static final int PHONE_LENGTH = 11;

    @Remark("15位身份证号码长度")
    public static final int IDCARD_15_LENGTH = 15;

    @Remark("18位身份证号码长度")
    public static final int IDCARD_18_LENGTH = 18;

    public static final String EXAMPLE_PASSWORD = "******";

    /**
     * null的字符串
     */
    public static final String NULL_STRING = "null";

    /**
     * 判断字符串是否为空, "null"这里也认为是空
     *
     * @param value
     * @return
     */
    public static boolean isNullOrEmpty(String value) {
        if (isEmpty(value)) {
            return true;
        }

        if (NULL_STRING.equalsIgnoreCase(value)) {
            return true;
        }

        return false;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param value
     * @return
     */
    public static boolean isNotNullOrEmpty(String value) {
        return !isNullOrEmpty(value);
    }

    public static boolean notEquals(final CharSequence cs1, final CharSequence cs2) {
        return !equals(cs1, cs2);
    }

    public static boolean notEqualsIgnoreCase(final CharSequence cs1, final CharSequence cs2) {
        return !equalsIgnoreCase(cs1, cs2);
    }
}
