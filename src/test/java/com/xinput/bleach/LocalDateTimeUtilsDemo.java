package com.xinput.bleach;

import com.xinput.bleach.util.LocalDateTimeUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-09-03 16:14
 */
public class LocalDateTimeUtilsDemo {

    @Test
    public void format() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(LocalDateTimeUtils.formatDateTime(localDateTime));
        System.out.println(LocalDateTimeUtils.formatDate(localDateTime));
        System.out.println(LocalDateTimeUtils.formatTime(localDateTime));
    }

    @Test
    public void parse() {
        String text1 = "2020-09-03 16:37:10";
        LocalDateTime l1 = LocalDateTimeUtils.parseLocalDateTime(text1);
        System.out.println("l1 " + l1.toString());

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String text2 = "2020-09-03 16:37";
        LocalDateTime l2 = LocalDateTimeUtils.parse(text2, dateTimeFormatter1);
        System.out.println(LocalDateTimeUtils.formatDateTime(l2));
    }

    @Test
    public void asDate() {
        System.out.println(LocalDateTimeUtils.as(new Date()));
        System.out.println(LocalDateTimeUtils.as(LocalDate.now()));
        System.out.println(LocalDateTimeUtils.asMillSecond(System.currentTimeMillis()));
        System.out.println(LocalDateTimeUtils.asSecond(System.currentTimeMillis() / 1000L));
    }
}
