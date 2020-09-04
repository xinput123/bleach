package com.xinput.bleach;

import com.xinput.bleach.util.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author xinput
 * @date 2020-08-03 15:21
 */
public class NumberUtilsDemo {

    @Test
    public void test01() {
        double aa = -19162431.1254;
        String a = "-19162431.1254";
        String b = "-19162431a1254";
        String c = "中文";
        System.out.println(NumberUtils.isNumeric(Double.toString(aa)));
        System.out.println(NumberUtils.isNumeric(a));
        System.out.println(NumberUtils.isNumeric(b));
        System.out.println(NumberUtils.isNumeric(c));

        Assert.assertEquals(NumberUtils.isNumeric(Double.toString(aa)), true);
        Assert.assertEquals(NumberUtils.isNumeric(a), true);
        Assert.assertEquals(NumberUtils.isNumeric(b), false);
        Assert.assertEquals(NumberUtils.isNumeric(c), false);
    }
}
