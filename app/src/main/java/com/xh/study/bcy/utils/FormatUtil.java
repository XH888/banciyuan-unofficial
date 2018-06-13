package com.xh.study.bcy.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.StringRes;

import com.xh.study.bcy.R;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化工具
 */

@SuppressLint("SimpleDateFormat")
public class FormatUtil
{

    public final static String FORMAT_YEAR = "yyyy";

    public final static String FORMAT_MONTH_DAY = "MM月dd日";

    public final static String FORMAT_DATE1 = "yyyy-MM-dd";

    public final static String FORMAT_DATE2 = "yyyy/MM/dd";

    public final static String FORMAT_TIME = "HH:mm";

    public final static String FORMAT_MONTH_DAY_TIME = "MM月dd日  hh:mm";

    public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm";

    public final static String FORMAT_DATE1_TIME = "yyyy/MM/dd HH:mm";

    public final static String FORMAT_DATE_TIME_SECOND = "yyyy/MM/dd HH:mm:ss";

    private static SimpleDateFormat sdf = new SimpleDateFormat();

    private static final int YEAR = 365 * 24 * 60 * 60;// 年

    private static final int MONTH = 30 * 24 * 60 * 60;// 月

    private static final int DAY = 24 * 60 * 60;// 天

    private static final int HOUR = 60 * 60;// 小时

    private static final int MINUTE = 60;// 分钟

    /**
     * 根据时间戳获取描述性时间，如3分钟前，1天前
     *
     * @param timestamp 时间戳 单位为毫秒
     * @return 时间字符串
     */

    public static String getDescriptionTimeFromTimestamp( long timestamp) {
        long currentTime = System.currentTimeMillis();
        // 与现在时间相差秒数
        long timeGap = (currentTime - timestamp) / 1000;
        String timeStr;

        if(timeGap > 7 * DAY){
            timeStr = longToString(timestamp,FORMAT_DATE2);
        } else if (timeGap > DAY  ) {
            // 1 - 7天
            timeStr = timeGap / DAY + "日前";
        } else if (timeGap > HOUR){
            // 1 - 24小时
            timeStr = timeGap / HOUR + "時間前";
        } else if (timeGap > MINUTE){
            // 1 - 60 分钟
            timeStr = timeGap / MINUTE + "分前";
        } else {
            timeStr = "先前";
        }
        return timeStr.concat("に更新");
    }

    public static String getDescriptionTimeFromTimestamp(Context context, long timestamp) {
        long currentTime = System.currentTimeMillis();
        // 与现在时间相差秒数
        long timeGap = (currentTime  / 1000)- timestamp;
        String timeStr;

        if (timeGap > HOUR){
            // 1 - 24小时
            timeStr = context.getString(R.string.hours_ago,timeGap / HOUR ) ;
        } else if (timeGap > MINUTE){
            // 1 - 60 分钟
            timeStr = context.getString(R.string.minutes_ago,timeGap / MINUTE ) ;
        } else {
            timeStr = "刚刚更新";
        }
        return timeStr ;
    }

    public static String formatNum(Context context, long num) {
        String timeStr=String.valueOf( num );
        if (num > 10000){
            timeStr = num/10000 +"W";
        }else if(num>1000){
            timeStr = Math.round(num/1000f*10)/10.0  +"K";
        }
        return timeStr ;
    }
    /**
     * 获取当前日期的指定格式的字符串
     *
     * @param format 指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return
     */

    public static String getCurrentTime(String format)
    {

        if (format == null || format.trim().equals(""))
        {
            sdf.applyPattern(FORMAT_DATE_TIME);
        } else
        {
            sdf.applyPattern(format);
        }
        return sdf.format(new Date());
    }


    /**
     * date类型转换为String类型
     * formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
     * data Date类型的时间
     *
     * @param data
     * @param formatType
     * @return
     */

    public static String dateToString(Date data, String formatType)
    {

        return new SimpleDateFormat(formatType).format(data);
    }

    /**
     * long类型转换为String类型
     * currentTime要转换的long类型的时间
     * formatType要转换的string类型的时间格式
     *
     * @param currentTime
     * @param formatType
     * @return
     */

    public static String longToString(long currentTime, String formatType)
    {

        String strTime;
        // long类型转成Date类型
        Date date = longToDate(currentTime, formatType);
        // date类型转成String
        strTime = dateToString(date, formatType);

        return strTime;
    }


    /**
     * string类型转换为date类型
     * strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
     * HH时mm分ss秒，
     * strTime的时间格式必须要与formatType的时间格式相同
     *
     * @param strTime
     * @param formatType
     * @return
     */

    public static Date stringToDate(String strTime, String formatType)
    {

        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        try
        {
            date = formatter.parse(strTime);
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * long转换为Date类型
     * currentTime要转换的long类型的时间
     * formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
     *
     * @param currentTime
     * @param formatType
     * @return
     */

    public static Date longToDate(long currentTime, String formatType)
    {

        // 根据long类型的毫秒数生命一个date类型的时间
        Date dateOld = new Date(currentTime);
        // 把date类型的时间转换为string
        String sDateTime = dateToString(dateOld, formatType);
        // 把String类型转换为Date类型
        Date date = stringToDate(sDateTime, formatType);
        return date;
    }

    /**
     * string类型转换为long类型
     * strTime要转换的String类型的时间
     * formatType时间格式
     * strTime的时间格式和formatType的时间格式必须相同
     *
     * @param strTime
     * @param formatType
     * @return
     */

    public static long stringToLong(String strTime, String formatType)
    {

        // String类型转成date类型
        Date date = stringToDate(strTime, formatType);
        if (date == null)
        {
            return 0;
        } else
        {
            // date类型转成long类型
            return dateToLong(date);
        }
    }

    /**
     * date类型转换为long类型
     * date要转换的date类型的时间
     *
     * @param date
     * @return
     */

    public static long dateToLong(Date date)
    {

        return date.getTime();
    }
}
