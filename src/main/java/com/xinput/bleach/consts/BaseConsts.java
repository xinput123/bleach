package com.xinput.bleach.consts;

import com.xinput.bleach.annotation.Remark;

public class BaseConsts {

    @Remark("有效")
    public static final int RECORD_STATE_VALID = 0;

    @Remark("无效")
    public static final int RECORD_STATE_INVALID = 1;

    @Remark("启用")
    public static final boolean ENABLE = true;

    @Remark("禁用")
    public static final boolean DISABLE = false;

    // ------------------------ 性别 ---------------------------

    public static final String MALE = "male";

    public static final String FEMALE = "female";

    public static final String M = "M";

    public static final String F = "F";

    // ------------------------ 开发环境 ---------------------------

    /**
     * 默认模式
     */
    public static final String DEFAULT = "default";

    /**
     * 开发模式
     */
    public static final String MODE_ACTIVE_DEV = "dev";

    /**
     * 测试模式
     */
    public static final String MODE_ACTIVE_TEST = "test";

    /**
     * 生产模式
     */
    public static final String MODE_ACTIVE_PROD = "prod";
}
