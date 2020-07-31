package com.bleach;

import com.google.common.collect.Lists;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xinput
 * @Date: 2020-07-31 13:56
 */
public class LocalDateUtils {

    /**
     * String -> LocalDate
     */
    public static LocalDate asLocalDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * Date -> LocalDate
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 计算两个日期相隔天数
     */
    public static int differentDays(LocalDate localDate1, LocalDate localDate2) {
        if (localDate1 == null || localDate2 == null) {
            throw new RuntimeException("日期不能为空");
        }

        /**
         * Period 用于计算时间间隔
         */
        return Period.between(localDate1, localDate2).getDays();
    }

    /**
     * 获取从其实日期到结束日期之间所有的日期
     *
     * @param beginDate 起始日期
     * @param endDate   结束日期
     * @return
     */
    public static List<LocalDate> getMiddleLocalDate(LocalDate beginDate, LocalDate endDate) {
        if (endDate.isBefore(beginDate)) {
            return Lists.newArrayList();
        }
        List<LocalDate> localDateList = new ArrayList<>();
        long length = endDate.toEpochDay() - beginDate.toEpochDay();
        for (long i = length; i >= 0; i--) {
            localDateList.add(endDate.minusDays(i));
        }
        return localDateList;
    }

    /**
     * 判断date1是否在date2之前
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isBeofre(LocalDate date1, LocalDate date2) {
        if (date1 == null) {
            return true;
        }

        if (date2 == null) {
            return false;
        }

        return date1.isBefore(date2);
    }

    /**
     * 判断date1是否在date2之后
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isAfter(LocalDate date1, LocalDate date2) {
        if (date1 == null) {
            return false;
        }

        if (date2 == null) {
            return true;
        }

        return date1.isAfter(date2);
    }

    /**
     * 判断两个日期是否相等
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqual(LocalDate date1, LocalDate date2) {
        if (date1 == null && date2 == null) {
            return true;
        }

        if (date1 != null && date2 != null) {
            return date1.isEqual(date2);
        }

        return false;
    }

    /**
     * 根据出生日期计算年龄
     *
     * @param birthday
     * @return
     */
    public static Integer calculateAge(LocalDate birthday) {
        if (birthday == null) {
            return null;
        }

        return birthday.until(LocalDate.now()).getYears();
    }
}
