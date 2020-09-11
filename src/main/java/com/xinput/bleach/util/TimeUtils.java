package com.xinput.bleach.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtils {
    private static final Pattern PATTERN = Pattern.compile("(([0-9]+?)((d|h|mi|min|mn|s)))+?");
    private static final Integer MINUTE = 60;
    private static final Integer HOUR = 60 * MINUTE;
    private static final Integer DAY = 24 * HOUR;

    /**
     * Parse a duration
     *
     * @param duration 3h, 2mn, 7s or combination 2d4h10s, 1w2d3h10s
     * @return The number of seconds
     */
    public static int parseDuration(String duration) {
        if (duration == null) {
            return 30 * DAY;
        }

        Matcher matcher = PATTERN.matcher(duration);
        int seconds = 0;
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid duration pattern : " + duration);
        }

        matcher.reset();
        while (matcher.find()) {
            if (StringUtils.equalsIgnoreCase("d", matcher.group(3))) {
                seconds += Integer.parseInt(matcher.group(2)) * DAY;
            } else if (StringUtils.equalsIgnoreCase("h", matcher.group(3))) {
                seconds += Integer.parseInt(matcher.group(2)) * HOUR;
            } else if (StringUtils.equalsIgnoreCase("mi", matcher.group(3))
                    || StringUtils.equalsIgnoreCase("min", matcher.group(3))
                    || StringUtils.equalsIgnoreCase("mn", matcher.group(3))) {
                seconds += Integer.parseInt(matcher.group(2)) * MINUTE;
            } else {
                seconds += Integer.parseInt(matcher.group(2));
            }
        }

        return seconds;
    }
}
