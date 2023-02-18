package com.gupao.springbootdemo.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
public class TimeUtils {

    /**
     * 单位：毫秒
     */
    public static final long SECOND = 1000L;
    public static final long MINUTE = 60 * SECOND;
    /**
     * 24 * 60 * 60 * 1000L
     */
    public static final long HOUR = 60 * MINUTE;

    public static final long DAY = 24 * HOUR;

    public static final long MONTH = 30 * DAY;

    /**
     * 获取当前时间 默认格式 "yyyy/MM/dd HH:mm:ss"
     */
    public static String getCurrentTime() {
        return FormatterEnums.LONG_DATETIME_TO_SECOND_WITH_COLON.formatter().format(LocalDateTime.now());
    }

    /**
     * 获取当前时间
     *
     * @param formatter 时间格式
     */
    public static String getCurrentTime(FormatterEnums formatter) {
        return formatter.formatter().format(LocalDateTime.now());
    }



    /**
     * 时间格式化
     *
     * @param dateTime 时间
     * @param formatter 格式
     * @return 格式化后的时间
     */
    public static String formatDatetime(LocalDateTime dateTime, FormatterEnums formatter) {
        return formatter.formatter().format(dateTime);
    }

    /**
     * 时间格式化
     *
     * @param timestamp 时间戳
     * @param formatter 格式
     * @return 格式化后的时间
     */
    public static String formatDatetime(Long timestamp, FormatterEnums formatter) {
        LocalDateTime dateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        return formatter.formatter().format(dateTime);
    }

    /**
     * 字符串转时间
     *
     * @param datetime 时间字符串
     * @param formatter 格式
     */
    public static LocalDateTime parseDatetime(String datetime, FormatterEnums formatter) {
        return LocalDateTime.parse(datetime, formatter.formatter());
    }

    public static LocalDate parseDate(String datetime, FormatterEnums formatter) {
        return LocalDate.parse(datetime, formatter.formatter());
    }

    /**
     * 时间类型转化
     *
     * @param date java.util.Date
     * @see Date 转
     * @see LocalDateTime
     */
    public static LocalDateTime dateToLocalDatetime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 时间类型转化
     *
     * @param ldt java.time.LocalDateTime
     * @see LocalDateTime 转
     * @see Date
     */
    public static Date ldtToDate(LocalDateTime ldt) {
        return Date.from(ldt.toInstant(ZoneOffset.ofHours(8)));
    }

    /**
     * 时间类型转化
     *
     * @see LocalDateTime 转
     * @see Date
     */
    public static LocalDateTime millToDate(Long mill) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mill), ZoneOffset.ofHours(8));
    }

    /**
     * 获取一天的开始
     */
    public static LocalDateTime getStartOfDay(LocalDateTime time) {
        return LocalDateTime.of(time.toLocalDate(), LocalTime.MIN);
    }

    public static LocalDateTime getStartOfDay(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MIN);
    }

    public static Long getStartOfDayMilli(LocalDateTime time) {
        return getStartOfDay(time).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
    public static Long getStartOfDayMilli(LocalDate date) {
        return getStartOfDay(date).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取一天的结束
     */
    public static LocalDateTime getEndOfDay(LocalDateTime time) {
        return LocalDateTime.of(time.toLocalDate(), LocalTime.MAX);
    }

    public static LocalDateTime getEndOfDay(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MAX);
    }

    public static Long getEndOfDayMilli(LocalDateTime time) {
        return getEndOfDay(time).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static Long getEndOfDayMilli(LocalDate date) {
        return getEndOfDay(date).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static long between(String start, String end) {
        return between(start, end, FormatterEnums.LONG_DATETIME_TO_SECOND_NO_CHAR);
    }

    public static long between(Long start, Long end) {
        long diff = millToDate(start).until(millToDate(end), ChronoUnit.MILLIS);
        return diff;
    }

    public static long between(String start, String end, FormatterEnums formatter) {
        LocalDateTime startTime = LocalDateTime.parse(start, formatter.formatter());
        LocalDateTime endTime = LocalDateTime.parse(end, formatter.formatter());

        return startTime.until(endTime, ChronoUnit.MILLIS);
    }

//    public static long betweenDays(Long start) {
//        //获取前一天的24点
//        long l = DateUtils.minusDayEnd(1) - start;
//        long oneday = 1000 * 60 * 60 * 24;
//        return l / oneday;
//    }

    /**
     * 计算第二天凌晨与当前时间的时间差秒数
     *
     * @return java.lang.Long
     * @date 2021/3/12 18:10
     */
    public static Long getNowToNextDaySeconds() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }

    public static boolean isSameDay(long millis1, long millis2, TimeZone timeZone) {
        long interval = millis1 - millis2;
        return interval < DAY && interval > -DAY && millis2Days(millis1, timeZone) == millis2Days(millis2,
                timeZone);
    }

    private static long millis2Days(long millis, TimeZone timeZone) {
        return (((long) timeZone.getOffset(millis)) + millis) / DAY;
    }


    public enum FormatterEnums {
        /**
         *
         */
        LONG_DATETIME_TO_SECOND_WITH_COLON("yyyy/MM/dd HH:mm:ss"),
        LONG_DATETIME_TO_SECOND_WITH_COLON2("yyyy-MM-dd HH:mm:ss"),
        LONG_DATETIME_TO_SECOND_NO_CHAR("yyyyMMddHHmmss"),
        LONG_DATETIME_TO_MS_NO_CHAR("yyyyMMddHHmmssSSS"),
        SHORT_DATETIME_TO_DAY_NO_CHAR("yyyyMMdd"),
        SHORT_DATETIME_TO_DAY_WITH_COLON("yyyy/MM/dd");

        FormatterEnums(String formatter) {
            this.formatter = formatter;
        }

        private String formatter;

        public DateTimeFormatter formatter() {
            return DateTimeFormatter.ofPattern(formatter);
        }


    }

    /**
     *
     */
    public static String formatDuration(long sec) {
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        StringBuilder format = new StringBuilder(10);
        seconds = sec * SECOND;
        if (seconds > HOUR) {
            hours = seconds / HOUR;
            seconds = seconds - hours * HOUR;
            format.append(hours).append("时");
        }
        if (seconds > MINUTE || format.length() > 0) {
            minutes = seconds / MINUTE;
            seconds = seconds - minutes * MINUTE;
            format.append(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(minutes), 2, "0")).append("分");
        }
        if (seconds > 0 || format.length() > 0) {
            format.append(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(seconds / SECOND), 2, "0"))
                    .append("秒");
        }
        return format.toString();
    }

    public static String getDateBefore(int day) {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -day);
        Date date = calendar.getTime();
        return df.format(date);
    }

    public static Integer getYesterday(Integer day) {

        LocalDate dateDay = parseDate(String.valueOf(day), FormatterEnums.SHORT_DATETIME_TO_DAY_NO_CHAR);
        LocalDate yesterday = dateDay.plusDays(-1);

        return Integer.valueOf(yesterday.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    public static Integer getToday() {
        LocalDate today = LocalDate.now();
        return Integer.valueOf(today.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    public static String getTodayReturnString() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static long transitTime(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(FormatterEnums.LONG_DATETIME_TO_SECOND_NO_CHAR.formatter);
        Date date = format.parse(time);
        return date.getTime();
    }

    public static long transferTime(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(FormatterEnums.LONG_DATETIME_TO_SECOND_WITH_COLON2.formatter);
        Date date = format.parse(time);
        return date.getTime();
    }


    /**
     * Gets time by age.
     *
     * @param age the age
     * @return the time by age
     */
    public static List<Long> getTimeByAge(int age) {

        List<Long> list = new ArrayList<>(2);
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -age);
        list.add(Long.parseLong(df.format(cal.getTime())));
        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DATE, -1);
        list.add(Long.parseLong(df.format(cal.getTime())));
        return list;
    }



    /**
     * Gets age.
     *
     * @param birthDay the birth day
     * @return the age
     */
    public static int getAge(Long birthDay) {

        try {

            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date date = df.parse(String.valueOf(birthDay));
            Calendar cal = Calendar.getInstance();
            if (cal.before(birthDay)) {
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH);
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(date);
            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH);
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
            int age = yearNow - yearBirth;
            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) {
                        age--;
                    }
                } else {
                    age--;
                }
            }
            return age;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("计算年龄失败");
        }
    }


    /**
     * 格式化时间 yyyyMM to localDate
     * @param timeStr 202108
     * @return localDate
     */
    public static LocalDate stringYearMonthToLocalDate(String timeStr) {
        DateTimeFormatter fmt =
                new DateTimeFormatterBuilder()
                        .appendPattern("yyyyMM")
                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                        .toFormatter();
        return LocalDate.parse(timeStr, fmt);
    }

    public static String longTimeToMonthYear(Long timeStr) {
        DateTimeFormatter fmt =
                new DateTimeFormatterBuilder()
                        .appendPattern("yyyy年M月")
                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                        .toFormatter();
        return millToDate(timeStr).format(fmt);
    }
}
