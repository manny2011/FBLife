package com.group.yztcedu.fblife.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Polaris on 2016/8/6.
 */
public class TimeUtils {
    public static String getTime(String time){
        Date date = new Date(Long.parseLong(time));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
