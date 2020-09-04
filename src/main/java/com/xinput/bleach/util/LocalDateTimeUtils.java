package com.xinput.bleach.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author xinput
 * LocalDateTime 工具类
 */
public class LocalDateTimeUtils {

    // ========================= LocalDateTime => 指定类型字符串 ======================

    /**
     * LocalDateTime -> yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(LocalDateTime localDateTime) {
        return format(localDateTime, DateUtils.DATE_TIME_FORMATTER);
    }

    /**
     * LocalDateTime -> yyyy-MM-dd
     */
    public static String formatDate(LocalDateTime localDateTime) {
        return format(localDateTime, DateUtils.DATE_FORMATTER);
    }

    /**
     * LocalDateTime -> HH:mm:ss
     */
    public static String formatTime(LocalDateTime localDateTime) {
        return format(localDateTime, DateUtils.TIME_FORMATTER);
    }

    /**
     * LocalDateTime -> 自定义格式
     */
    public static String format(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime.format(dateTimeFormatter);
    }

    // ========================= 指定类型字符串 => LocalDateTime ======================

    /**
     * yyyy-MM-dd HH:mm:ss -> LocalDateTime
     */
    public static LocalDateTime parseLocalDateTime(String dateString) {
        return parse(dateString, DateUtils.DATE_TIME_FORMATTER);
    }

    /**
     * yyyy-MM-dd HH:mm:ss -> LocalDateTime
     */
    public static LocalDateTime parse(String dateString, DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime.parse(dateString, dateTimeFormatter);
    }

    // ===============================================

    /**
     * Date -> LocalDateTime
     */
    public static LocalDateTime as(Date date) {
        try {
            return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * LocalDate -> LocalDateTime
     */
    public static LocalDateTime as(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.parse("00:00:00"));
    }

    /**
     * 时间戳(毫秒) -> LocalDateTime
     */
    public static LocalDateTime asMillSecond(Long millSecond) {
        return Instant.ofEpochMilli(millSecond).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 时间戳(秒) -> LocalDateTime
     */
    public static LocalDateTime asSecond(Long second) {
        return Instant.ofEpochSecond(second).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }
}
