package com.bleach;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: xinput
 * Date工具类 工具类
 */
public class DateUtils extends DateFormatUtils {

    /**
     * LocalDate -> Date
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime -> Date
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 计算date1和date2隔了多少天
     *
     * @param date1
     * @param date2
     * @return 如果返回值为0，表示同一天，如果大于0，表示date2在date1之后多少天，如果小于0，表示date2在date1之前多少天
     */
    public static int differentDays(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new RuntimeException("日期不能为空");
        }
        LocalDate localDate1 = LocalDateUtils.asLocalDate(date1);
        LocalDate localDate2 = LocalDateUtils.asLocalDate(date2);

        /**
         * Period 用于计算时间间隔
         */
        return Period.between(localDate1, localDate2).getDays();
    }

    /**
     * 计算date1和date2之间隔了多少天，只有非负数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int betweenDays(Date date1, Date date2) {
        return Math.abs(differentDays(date1, date2));
    }

}
