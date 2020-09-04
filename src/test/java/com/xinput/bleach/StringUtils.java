package com.xinput.bleach;

import com.xinput.bleach.util.NumberUtils;
import org.junit.Test;

/**
 * @author xinput
 * @date 2020-09-01 22:07
 */
public class StringUtils {

    private static final char PACKAGE_SEPARATOR_CHAR = '.';

    public static String simpleClassName(Class<?> clazz) {
        String className = checkNotNull(clazz, "clazz").getName();
        final int lastDotIdx = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR);
        if (lastDotIdx > -1) {
            return className.substring(lastDotIdx + 1);
        }
        return className;
    }

    public static <T> T checkNotNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }

    @Test
    public void test() {
        System.out.println(simpleClassName(NumberUtils.class) + "#0");
    }
}
