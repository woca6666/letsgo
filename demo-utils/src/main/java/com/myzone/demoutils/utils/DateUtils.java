package com.myzone.demoutils.utils;



import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类

 * @version 2017-1-4
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH", "yyyy.MM",
            "yyyy年MM月dd日", "yyyy年MM月dd日 HH时mm分ss秒", "yyyy年MM月dd日 HH时mm分", "yyyy年MM月dd日 HH时", "yyyy年MM月",
            "yyyy"};

    /**
     * 得到日期字符串 ，转换格式（yyyy-MM-dd）
     */
    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(long dateTime, String pattern) {
        return formatDate(new Date(dateTime), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, String pattern) {
        String formatDate = null;
        if (date != null){
//            if (StringUtils.isNotBlank(pattern)) {
//                formatDate = DateFormatUtils.format(date, pattern);
//            } else {
//                formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
//            }
            if (StringUtils.isBlank(pattern)) {
                pattern = "yyyy-MM-dd";
            }
            formatDate = FastDateFormat.getInstance(pattern).format(date);
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
//        return DateFormatUtils.format(new Date(), pattern);
        return FastDateFormat.getInstance(pattern).format(new Date());
    }

    /**
     * 得到当前日期前后多少天，月，年的日期字符串
     * @param pattern 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     * @param amont 数量，前为负数，后为正数
     * @param type 类型，可参考Calendar的常量(如：Calendar.HOUR、Calendar.MINUTE、Calendar.SECOND)
     * @return
     */
    public static String getDate(String pattern, int amont, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(type, amont);
//        return DateFormatUtils.format(calendar.getTime(), pattern);
        return FastDateFormat.getInstance(pattern).format(calendar.getTime());
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式   see to DateUtils#parsePatterns
     */
    public static Date parseDate(Object str) {
        if (str == null){
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 获取过去的天数
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(24*60*60*1000);
    }


    /**
     * 获取过去的小时
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(60*60*1000);
    }

    /**
     * 获取过去的分钟
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(60*1000);
    }

    /**
     * 获取过去的秒
     * @param date
     * @return
     */
    public static long pastSecnod(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(1000);
    }
    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 获取某月有几天
     * @param date 日期
     * @return 天数
     */
    public static int getMonthHasDays(Date date){
//        String yyyyMM = new SimpleDateFormat("yyyyMM").format(date);
        String yyyyMM = FastDateFormat.getInstance("yyyyMM").format(date);
        String year = yyyyMM.substring(0, 4);
        String month = yyyyMM.substring(4, 6);
        String day31 = ",01,03,05,07,08,10,12,";
        String day30 = "04,06,09,11";
        int day = 0;
        if (day31.contains(month)) {
            day = 31;
        } else if (day30.contains(month)) {
            day = 30;
        } else {
            int y = Integer.parseInt(year);
            if ((y % 4 == 0 && (y % 100 != 0)) || y % 400 == 0) {
                day = 29;
            } else {
                day = 28;
            }
        }
        return day;
    }

    /**
     * 获取日期是当年的第几周
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取一天的开始时间（如：2015-11-3 00:00:00.000）
     * @param date 日期
     * @return
     */
    public static Date getOfDayFirst(Date date) {
        if (date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取一天的最后时间（如：2015-11-3 23:59:59.999）
     * @param date 日期
     * @return
     */
    public static Date getOfDayLast(Date date) {
        if (date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取服务器启动时间
     * @param
     * @return
     */
    public static Date getServerStartDate(){
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 格式化为日期范围字符串
     * @param beginDate 2018-01-01
     * @param endDate 2018-01-31
     * @return 2018-01-01 ~ 2018-01-31

     */
    public static String formatDateBetweenString(Date beginDate, Date endDate){
        String begin = DateUtils.formatDate(beginDate);
        String end = DateUtils.formatDate(endDate);
        if (StringUtils.isNoneBlank(begin, end)){
            return begin + " ~ " + end;
        }
        return null;
    }

    /**
     * 解析日期范围字符串为日期对象
     * @param dateString 2018-01-01 ~ 2018-01-31
     * @return new Date[]{2018-01-01, 2018-01-31}

     */
    public static Date[] parseDateBetweenString(String dateString){
        Date beginDate = null; Date endDate = null;
        if (StringUtils.isNotBlank(dateString)){
            String[] ss = StringUtils.split(dateString, "~");
            if (ss != null && ss.length == 2){
                String begin = StringUtils.trim(ss[0]);
                String end = StringUtils.trim(ss[1]);
                if (StringUtils.isNoneBlank(begin, end)){
                    beginDate = DateUtils.parseDate(begin);
                    endDate = DateUtils.parseDate(end);
                }
            }
        }
        return new Date[]{beginDate, endDate};
    }

    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
    public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }
    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    /**
     * 给时间加上几个小时
     * @param date 时间
     * @param hour 需要加的时间
     * @return
     */
    public static String addDateMinut(Date date, int hour){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }

    /**
     * 给时间加上几个小时
     * @param date 时间
     * @param hour 需要加的时间
     * @return DATE
     */
    public static Date addDate(Date date, int hour){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        cal = null;
        return date;
    }

    /**
     * 日期比较
     * @param date1 日期参数1
     * @param date2 日期参数2
     * @return 1 date1>date2;-1 date1<date2;0 date1=date2
     */
    public static int compareDate(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
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

    //获取当前日期的周一
    public static String getWeekFirstDayByDate(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        return sdf.format(cal.getTime());
    }

    //获取当前月份或年份
    public static String getMonthOrYearByDate(Date time, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format); // 设置时间格式
        return sdf.format(time);
    }

    /**
     * 获取当前季度
     *
     */
    public static String getQuarter() {
        Calendar c = Calendar.getInstance();
        int month = c.get(c.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return quarter + "";
    }

    /**
     * 获取当前季度开始的月份
     *
     */
    public static String getQuarterFirstMonth() {
        Calendar c = Calendar.getInstance();
        int month = c.get(c.MONTH) + 1;
        String temp = "";
        if (month >= 1 && month <= 3) {
            temp = c.get(c.YEAR) + "-01";
        } else if (month >= 4 && month <= 6) {
            temp = c.get(c.YEAR) + "-04";
        } else if (month >= 7 && month <= 9) {
            temp = c.get(c.YEAR) + "-07";
        } else {
            temp = c.get(c.YEAR) + "-10";
        }
        return temp;
    }

    /**
     * 根据时间 和时间格式 校验是否正确
     * @param sDate 校验的日期
     * @param format 校验的格式
     * @return
     */
    public static boolean isLegalDate(String sDate,String format) {
        if (StringUtils.isEmpty(sDate)) {
            return false;
        }
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws ParseException {

//        System.out.println(addDateTime("2021-02-28", 0, 2));

        System.out.println(isLegalDate("2021-06-21", "yyyy-MM-dd"));

//        System.out.println(getQuarterFirstMonth());
//        System.out.println(getWeekFirstDayByDate(new Date()));
//        System.out.println(getMonthOrYearByDate(new Date(), "yyyy-MM"));
//        System.out.println(getMonthOrYearByDate(new Date(), "yyyy"));
//        compareDate("2018-09-15 20:20:00","2018-09-15 20:20:00");
//        System.out.println(formatDate(parseDate("2010/3/6")));
//        System.out.println(getDate("yyyy年MM月dd日 E"));
//        long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//        System.out.println(time/(24*60*60*1000));
//        System.out.println(getWeekOfYear(new Date()));
//        System.out.println(formatDate(getOfDayFirst(parseDate("2015/3/6")),"yyyy-MM-dd HH:mm:ss.sss"));
//        System.out.println(formatDate(getOfDayLast(parseDate("2015/6/6")),"yyyy-MM-dd HH:mm:ss.sss"));
    }

}
