package com.meiwufang.mm.maker.helper;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by linhomhom on 15-1-16.
 */
@Singleton
public class FormatHelper {
    @Inject
    public FormatHelper() {
    }

    public String formatPhoneNum(String phoneNum){
        String before = phoneNum.substring(0, 3);
        String after = phoneNum.substring(7, 11);
        return before + "***" + after;
    }

    public boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    //取现在的月日时间串
    public String getTodayString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public String formatDateLongToString(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        return sdf.format(new Date(time));
    }

    /**
     * jumpinus
     * 转换成 shijian
     * @param time
     * @return
     */
    public String formatDateUnixLongToString(long time) {
        String date = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date(time * 1000));
        return date;
    }

    public Date formatDateLongToDate(long time){
        return new Date(time);
    }


    public String getCurrentDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public String getNumberCN(int num){
        String cn = "一";
        switch (num){
            case 1:
                cn = "一";
                break;
            case 2:
                cn = "二";
                break;
            case 3:
                cn = "三";
                break;
            case 4:
                cn = "四";
                break;
            case 5:
                cn = "五";
                break;
            case 6:
                cn = "六";
                break;
            case 7:
                cn = "七";
                break;
            case 8:
                cn = "八";
                break;
            case 9:
                cn = "九";
                break;
        }
        return cn;
    }
}
