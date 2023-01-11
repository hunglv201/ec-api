package com.vn.ec.utlis;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static final String DATE_PATTERN_DDMMYYYY = "ddMMYYYY";

    public static final String DATE_PATTERN_HHMMSS = "HH:mm:ss";

    public static final String DATE_PATTERN_YYYY = "YYYY";

    public static final String DATE_PATTERN_MM = "MM";
    public static final String TIME_ZONE_VI = "Asia/Ho_Chi_Minh";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeUtils() {
    }

    public static Date formatDate(String date, String pattern) {
        if(StringUtils.isBlank(date) || StringUtils.isBlank(pattern))
            return null;
        SimpleDateFormat format;
        try {
            format = new SimpleDateFormat(pattern);
            format.setLenient(false);
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Timestamp timestampBefore(long amount, ChronoUnit chronoUnit) {
        Instant instant = Instant.now();
        instant.plus(amount, chronoUnit);
        return Timestamp.from(instant);
    }

    public static Timestamp resultTimestamp() {
        Instant instant = Instant.now();
        return Timestamp.from(instant);
    }

    public static Timestamp getTimestampAfter(int amount, ChronoUnit chronoUnit) {
        Instant instant = Instant.now();
        instant = instant.plus(amount, chronoUnit);
        return Timestamp.from(instant);
    }

    public static Timestamp resultTimestampAfter24h() {
        Instant instant = Instant.now();
        instant = instant.plus(24, ChronoUnit.HOURS);
        return Timestamp.from(instant);
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getCurrentTimeWithFormat(String pattern) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            dateFormat.applyPattern(pattern);
            return dateFormat.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDateTimeWithFormatBefore(String pattern, int day) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            dateFormat.applyPattern(pattern);
            Calendar date = Calendar.getInstance();
            date.add(Calendar.DATE, -day);
            return dateFormat.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String resultDateConvertToString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static Date resultDate(String date, String pattern) {
        SimpleDateFormat format;
        try {
            format = new SimpleDateFormat(pattern);
            format.setLenient(false);
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Timestamp resultTimeStamp(Date d) {
        return new Timestamp(d.getTime());
    }
}
