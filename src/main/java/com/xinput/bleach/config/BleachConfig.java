package com.xinput.bleach.config;

import com.google.common.collect.Lists;
import com.xinput.bleach.consts.BleachConsts;
import com.xinput.bleach.util.SimpleProperties;
import com.xinput.bleach.util.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

/**
 * @author xinput
 * @date 2020-06-21 09:46
 */
public class BleachConfig {

    public static SimpleProperties SP;

    static {
        try {
            SP = SimpleProperties.readConfiguration(BleachConsts.DEFAULT_SYSTEM_FILE);
        } catch (Exception e) {
            SP = null;
        }
    }

    /**
     * 获取微信小程序id
     */
    public static String getWechatAppid() {
        return get(BleachConsts.WECHAT_APPID);
    }

    /**
     * 获取微信小程序 secret
     */
    public static String getWechatSecret() {
        return get(BleachConsts.WECHAT_SECRET);
    }

    public static final int getInt(String key, int defaultValue) {
        if (SP == null) {
            return 0;
        }

        return SP.getIntProperty(key, defaultValue);
    }


    /**
     * 获取自定义key对应的value
     *
     * @param key
     * @return
     */
    public static final String get(String key) {
        return get(key, StringUtils.EMPTY);
    }

    /**
     * 获取自定义key对应的value,如果不存在，使用默认值 defaultValue
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static final String get(String key, String defaultValue) {
        if (SP == null) {
            return defaultValue;
        }

        return SP.getStringProperty(key, defaultValue);
    }

    public static final boolean getBoolean(String key) {
        return getBoolean(key, Boolean.FALSE);
    }

    public static final boolean getBoolean(String key, boolean defaultValue) {
        if (SP == null) {
            return defaultValue;
        }

        return SP.getBooleanProperty(key, defaultValue);
    }

    public static final List<String> getList(String key) {
        return getList(key, Lists.newArrayList());
    }

    public static final List<String> getList(String key, List<String> defaultList) {
        if (SP == null) {
            return defaultList;
        }

        String[] arrs = SP.getStringArrayProperty(key);
        if (ArrayUtils.isEmpty(arrs)) {
            return Lists.newArrayList(arrs);
        }

        return defaultList;
    }
}
