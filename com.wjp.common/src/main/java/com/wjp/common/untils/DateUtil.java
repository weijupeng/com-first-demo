package com.wjp.common.untils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Description：时间操作工具类
 *
 * @author : xutao Created_Date : 2017-05-22 17:57
 */
public class DateUtil {
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
    public static final String DATE_PATTERN_YYMM = "yyyyMM";

    public static final String DATE_PATTERN_YYMMDD = "yyyyMMdd";

    public static final String DATE_PATTERN_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DATE_PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String DATE_PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String DATE_PATTERN_PATTERN = "yyyy/MM/dd HH:mm:ss";

    public static final String DATE_PATTERN_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String DATE_PATTERN_YYYYMMDDHH = "yyyyMMddHH";

    public static final String DATE_PATTERN_YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String DATE_PATTERN_MM_DD = "MM-dd";

    public static final String DATE_PATTERN_YY_MM = "YY-MM";

    public static final Integer NINETY_DAYS_SECONDS = 90 * 24 * 60 * 60;

    public static final Long THIRTY_MINUTES_MILLISECONDS = 30 * 60 * 1000L;

    public static final Long ONE_DAY_MILLISECONDS = 60 * 60 * 24 * 1000L;

    public static final Long ONE_MONTH_MILLISECONDS = 60 * 60 * 24 * 30 * 1000L;

    public static final Integer ONE_DAY_SECOND = 86400;

    public static final Long ONE_MINUTE_MILLISECONDS = 60 * 1000L;

    public static final Long ONE_HOUR_SECONDS = 60 * 60 * 1000L;

    public static final Long TWO_HOUR_SECONDS = 2 * 60 * 60 * 1000L;

    public static final Long ONE_MONTH_SECONDS = 60 * 60 * 24 * 30L;

    public static final Long FIFTEEN_MINITES_MILLISECONDS = 15 * 60 * 1000L;

    public static final Integer TWELVE_HOURS_SECONDS = 43200;

    /**
     * 获取年
     *
     * @param date 参数
     *
     * @return 年
     */
    public static String getYear(Date date) {
        if (date == null) {
            throw new RuntimeException("参数date不能为空！");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 获取月
     *
     * @param date 参数
     *
     * @return 月
     */
    public static String getMonth(Date date) {
        if (date == null) {
            throw new RuntimeException("参数date不能为空！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(date);
    }

    /**
     * 获取日
     *
     * @param date 参数
     *
     * @return 日
     */
    public static String getDay(Date date) {
        if (date == null) {
            throw new RuntimeException("参数date不能为空！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(date);
    }

    /**
     * 按照指定的格式转换日期
     *
     * @param sourceDate 日期
     * @param pattern    格式
     *
     * @return 日期字符串
     */
    public static String dateToString(Date sourceDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(sourceDate);
    }

    /**
     * 按照默认的格式转换日期
     *
     * @param sourceDate 日期
     *
     * @return 日期字符串
     */
    public static String dateToString(Date sourceDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(sourceDate);
    }

    /**
     * 按照默认的格式转换日期
     *
     * @param date      日期
     * @param formatStr 指定格式
     *
     * @return 日期字符串
     */
    public static Date dateToDate(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String str = sdf.format(date);
        try {
            date = sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    /**
     * 毫秒值转换成日期字符串
     *
     * @param milliseconds 毫秒值
     *
     * @return 日期字符串
     */
    public static String millisToString(Long milliseconds) {
        if (milliseconds == null) {
            throw new RuntimeException("时间（毫秒）不能为空");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return dateToString(calendar.getTime());
    }

    /**
     * 按照指定格式转换毫秒值到日期字符串
     *
     * @param milliseconds 毫秒值
     * @param pattern      格式
     *
     * @return 日期字符串
     */
    public static String millisToString(Long milliseconds, String pattern) {
        if (milliseconds == null) {
            throw new RuntimeException("时间（毫秒）不能为空");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return dateToString(calendar.getTime(), pattern);
    }

    /**
     * Date转成毫秒值
     *
     * @param sourceDate Date实例
     *
     * @return Date实例对应的毫秒值
     */
    public static Long dateToMillis(Date sourceDate) {
        if (sourceDate == null) {
            throw new RuntimeException("时间参数不能为空");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        return calendar.getTimeInMillis();
    }

    /**
     * 两日期比较
     *
     * @param date1
     * @param date2
     *
     * @return
     */
    public static int compareDate(Date date1, Date date2) {
        try {
            Date dt1 = DateUtil.dateToDate(date1, DateUtil.DATE_PATTERN_YYYY_MM_DD);
            Date dt2 = DateUtil.dateToDate(date2, DateUtil.DATE_PATTERN_YYYY_MM_DD);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取2个时间点之间的小时数 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     *
     * @param start 开始时间
     * @param end   结束时间
     *
     * @return 开始、结束时间之间的小时差
     */
    public static long getHoursBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if (start.compareTo(end) > 0) {
            return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        long minutesInMilli = secondsInMilli * 60;//分钟
        long hoursInMilli = minutesInMilli * 60;//小时
        return differ / hoursInMilli;
    }

    /**
     * 获取2个时间点之间分钟数 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     *
     * @param start 开始时间
     * @param end   结束时间
     *
     * @return 开始、结束时间之间的分钟差
     */
    public static long getMinutesBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if (start.compareTo(end) > 0) {
            return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        long minutesInMilli = secondsInMilli * 60;//分钟
        return differ / minutesInMilli;
    }

    /**
     * 获取2个时间点之间秒数 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     *
     * @param start 开始时间
     * @param end   结束时间
     *
     * @return 开始、结束时间之间的秒数差
     */
    public static long getSecondsBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if (start.compareTo(end) > 0) {
            return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        return differ / secondsInMilli;
    }

    /**
     * 获取2个时间点之间的天数
     *
     * @param start
     * @param end
     *
     * @return
     */
    public static int getDaysBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        long longs = (end.getTime() - start.getTime());
        int days = (int) (longs / (24 * 60 * 60 * 1000));
        return days;
    }

    /**
     * 获取2个时间点之间的天数，忽略时分秒
     *
     * @param start 开始时间
     * @param end   结束时间
     *
     * @return
     */
    public static int getDaysBetweenTwoDaysIgnoreMinAndSec(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        String startStr = DateUtil.dateToString(start, DateUtil.DATE_PATTERN_YYYY_MM_DD);
        String endStr = DateUtil.dateToString(end, DateUtil.DATE_PATTERN_YYYY_MM_DD);

        Date formatStartDate = DateUtil.stringToDate(startStr, DateUtil.DATE_PATTERN_YYYY_MM_DD);
        Date formatEndDate = DateUtil.stringToDate(endStr, DateUtil.DATE_PATTERN_YYYY_MM_DD);

        return DateUtil.getDaysBetweenTwoDate(formatStartDate, formatEndDate);
    }

    /**
     * 加减 N 天
     *
     * @param value 基础时间
     * @param num   正数为加运算，负数为减运算
     *
     * @return 加、减num天数后的Date实例
     */
    public static Date addOrSubtractDays(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.DATE, num);
        return c.getTime();
    }

    /**
     * 加减 N 分钟
     *
     * @param value 基础时间
     * @param num   正数为加运算，负数为减运算
     *
     * @return 加、减num分钟数后的Date实例
     */
    public static Date addOrSubtractMinute(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.MINUTE, num);
        return c.getTime();
    }

    /**
     * 查询过去X个工作日/非工作日
     *
     * @param date         当前时间
     * @param isWorkingDay 是否工作日
     * @param lastXDay     前n天
     */
    public static List<Date> queryLastXDay(Date date, Boolean isWorkingDay, Integer lastXDay) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int count = 1;
        List<Date> list = new ArrayList<>();

        while (count <= lastXDay) {
            now.add(Calendar.DATE, -1);// 日期向前进1
            int day = now.get(Calendar.DAY_OF_WEEK);// 此时的日期标记

            if (isWorkingDay) {
                if (day != Calendar.SUNDAY && day != Calendar.SATURDAY) {
                    list.add(now.getTime());
                    count++;
                }
            } else {
                if (day == Calendar.SUNDAY || day == Calendar.SATURDAY) {
                    list.add(now.getTime());
                    count++;
                }
            }
        }

        log.debug("获得向前追溯[{}]天 (是否工作日-[{}]) 日期列表: [{}]", lastXDay, isWorkingDay, list);
        return list;
    }

    /**
     * 字符串转Date，按照指定pattern格式
     *
     * @param dateStr 字符串格式时间
     * @param pattern 转换模板
     *
     * @return 转换后的Date实例
     * @throws ParseException
     */
    public static Date stringToDate(String dateStr, String pattern) {
        if (StringUtils.isAnyBlank(dateStr, pattern)) {
            throw new RuntimeException("Parameters cannot be [null] , give them a appropriate value");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 字符串时间，指定pattern，转毫秒值
     *
     * @param dataStr 日期字符串
     * @param pattern 规则
     *
     * @return 日期毫秒值
     * @throws ParseException 解析异常
     */
    public static Long stringToMillis(String dataStr, String pattern) throws ParseException {
        Date dateTemp = stringToDate(dataStr, pattern);
        return dateToMillis(dateTemp);
    }

    public static String stringToString(String value, String from, String to) throws ParseException {
        return dateToString(stringToDate(value, from), to);
    }

    /**
     * 返回此刻时间字符串
     *
     * @return 当前时间字符串格式
     */
    public static String now() {
        return dateToString(new Date());
    }

    public static Long getMsBetweenTwoMilliSeconds(Long begin, Long end) {
        if (begin == null || end == null) {
            throw new RuntimeException("Must offer two not-null param");
        }
        return end - begin;
    }

    /**
     * 两日期相距月数
     *
     * @param start
     * @param end
     *
     * @return
     * @throws ParseException
     */
    public static int getMonthsBetweenTwoDate(String start, String end) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calStart = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();

        try {
            calStart.setTime(sdf.parse(start));
            calEnd.setTime(sdf.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        result = (calEnd.get(Calendar.YEAR) - calStart.get(Calendar.YEAR)) * 12
                + (calEnd.get(Calendar.MONTH) - calStart.get(Calendar.MONTH));

        return result;

    }

    /**
     * 判断两个日期之间是否满足给定月数
     *
     * @param start
     * @param end
     * @param month
     *
     * @return
     */
    public static boolean isSatisfiedMonthsBetweenTwoDate(Date start, Date end, int month) {
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(start);
        calStart.add(Calendar.MONTH, month);

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(end);

        return calEnd.after(calStart);
    }

    //获取年龄
    public static Integer getAge(String identityNo) {
        if (StringUtils.isBlank(identityNo) || identityNo.length() != 18) {
            return null;
        }
        String birth = identityNo.substring(6, 14);
        String birthDay = null;
        try {
            birthDay = DateUtil.stringToString(birth, "yyyyMMdd", "yyyy-MM-dd");
            int days = getDaysBetweenTwoDate(stringToDate(birthDay, "yyyy-MM-dd"), new Date());
            return days / 365;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回今天还剩余的秒数
     *
     * @return 剩余的秒数
     */
    public static Long getSecondsTodayLeft() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return getSecondsBetweenTwoDate(now, calendar.getTime());
    }

    /**
     * 获取两个日期间的毫秒数
     *
     * @param begin 开始时间
     * @param end   结束时间
     *
     * @return
     */
    public static Long getMillisBetweenTwoDate(Date begin, Date end) {
        return end.getTime() - begin.getTime();
    }

    /**
     * 当前是否在设定的时间段内
     * <p>
     * 注意 : 参数仅支持HH:mm格式
     *
     * @param start 开始时间
     * @param end   结束时间
     *
     * @return
     */
    public static boolean isBetween(String start, String end) {
        String[] nowTemp = dateToString(new Date(), "HH:mm").split(":");
        int nowHour = Integer.valueOf(nowTemp[0]);
        int nowMinute = Integer.valueOf(nowTemp[1]);
        String[] startTemp = start.split(":");
        int startHour = Integer.valueOf(startTemp[0]);
        int startMinute = Integer.valueOf(startTemp[1]);
        String[] endTemp = end.split(":");
        int endHour = Integer.valueOf(endTemp[0]);
        int endMinute = Integer.valueOf(endTemp[1]);

        if ((startHour > endHour) || (startHour == endHour && startMinute > endMinute)) {
            throw new IllegalArgumentException("start,end");
        }

        return nowHour >= startHour && nowHour <= endHour && ((nowHour == startHour && nowMinute >= startMinute) || (nowHour == endHour && nowMinute <= endMinute) || (nowHour > startHour && nowHour < endHour));
    }

    /**
     * 当前是否在设定的时间段内，支持跨天（即start>end）
     * <p>
     * 注意 : 参数仅支持HH:mm格式
     *
     * @param start
     * @param end
     *
     * @return
     */
    public static boolean isBetweenCrossDay(String start, String end) {
        String[] startTemp = start.split(":");
        int startHour = Integer.valueOf(startTemp[0]);
        int startMinute = Integer.valueOf(startTemp[1]);
        String[] endTemp = end.split(":");
        int endHour = Integer.valueOf(endTemp[0]);
        int endMinute = Integer.valueOf(endTemp[1]);

        if ((startHour > endHour) || (startHour == endHour && startMinute > endMinute)) {
            return isBetween(start, "23:59") || isBetween("00:00", end);
        }
        return isBetween(start, end);
    }

    /**
     * 将当前日起以特殊的形式显示出来
     */
    public static HashMap<String, Object> getNowDate(Date dateTime) {

        Calendar nowDateCalendar = Calendar.getInstance();
        nowDateCalendar.setTime(dateTime);//当前日期
        nowDateCalendar.add(Calendar.MONTH, 1);
        int year = nowDateCalendar.get(Calendar.YEAR);
        int month = nowDateCalendar.get(Calendar.MONTH);
        int date = nowDateCalendar.get(Calendar.DATE);
        //针对12月的数据 做特殊处理
        if (month == 0) {
            month = 12;
            year = year - 1;
        }
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String yearStr = String.valueOf(year);
        String monthStr = String.valueOf(month);
        String dateStr = String.valueOf(date);

        resultMap.put("yearStr", yearStr);
        resultMap.put("monthStr", monthStr);
        resultMap.put("dateStr", dateStr);
        return resultMap;
    }

    public static Date addMonth(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.MONTH, num);
        return c.getTime();
    }

    /**
     * 计算日期加上毫秒数后的日期
     *
     * @param date 日期
     *
     * @return
     */
    public static String dateAddMs(Date date, Long ms) {
        String newDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date.getTime() + ms);
        return newDate;
    }

    /**
     * 返回以秒为单位(长度为10)的时间戳
     *
     * @param date
     *
     * @return
     */
    public static long getTimeStampBySeconds(Date date) {
        //毫秒级demo：1497260239660，13位
        //秒级demo：1497260239，10位
        //使用Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0,10));也可以
        long seconds = 0l;
        if (null == date) {
            seconds = (System.currentTimeMillis()) / 1000;//取商
        } else {
            seconds = (date.getTime()) / 1000;//取商
        }
        return seconds;
    }

    /**
     * 获取指定时间前多少个小时的时间点
     *
     * @param date       日期
     * @param beforeHour 小时数
     *
     * @return
     */
    public static Date beforeHourToDate(Date date, Integer beforeHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - beforeHour);
        return calendar.getTime();
    }

    /**
     * 是否在指定时间内
     *
     * @return
     */
    public static boolean isValidTime() {
        Date date = new Date();
        Integer time = date.getHours();
        Integer minutes = date.getMinutes();
        if (time >= 0 && time < 22) {
            if (time >= 21 && time < 22 && minutes >= 30) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断某天是否是工作日
     *
     * @param date 某天
     *
     * @return 是否是工作日 布尔
     */
    public static boolean isWorkingDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
    }


    /**
     * 新增天数
     */
    public static Date addDay(Date date, int intValueExact) {
        Calendar cal = calendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, intValueExact);
        return cal.getTime();
    }

    /**
     * 获取中国日历
     */
    public static Calendar calendar() {
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
        cal.setFirstDayOfWeek(2);
        return cal;
    }

    /**
     * 判断在某个时间内
     *
     * @param startTime
     * @param endTime
     * @param date
     *
     * @return
     */
    public static boolean between(Date startTime, Date endTime, Date date) {
        return (date.after(startTime) && date.before(endTime)) || (date.compareTo(startTime) == 0 || date.compareTo(endTime) == 0);
    }

    /**
     * 功能描述：返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = GregorianCalendar.getInstance(Locale.CHINESE);
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = GregorianCalendar.getInstance(Locale.CHINESE);
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 加减 N 月
     *
     * @param value 基础时间
     * @param num   正数为加运算，负数为减运算
     *
     * @return 加、减num天数后的Date实例
     */
    public static Date addOrSubtractMonths(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.MONTH, num);
        return c.getTime();
    }

    /**
     * 获取当前日期
     */
    public static String now(String format) {
        if (StringUtils.isBlank(format)) {
            format = DATE_PATTERN_YYYY_MM_DD;
        }
        return dateToString(new Date(), format);
    }

    /**
     * 获取当天零时零分零秒时间
     */
    public static Date initDateByDay() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = startOfDay.atZone(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime时间转换成字符串格式
     *
     * @param localDateTime 时间
     *
     * @return
     */
    public static String formatFullTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, DateUtil.DATE_PATTERN_YYYYMMDDHHMMSS);
    }

    /**
     * LocalDateTime时间转换成字符串格式
     *
     * @param localDateTime 时间
     * @param pattern       时间格式
     *
     * @return
     */
    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    public static void main(String[] args) {
        String s = dateToString(new Date(1557724578L));
        System.out.println(s);
    }

}
