package com.xudy.tbke.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s){
        if(s=="" ||s==null){
            return "";
        }
        try{
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(s);
            long ts = date.getTime() / 1000;
            res = String.valueOf(ts);
            return res;
        }catch(Exception e){
            System.out.println("出现异常："+e);    //打印异常信息
            e.printStackTrace();            //打印完整的异常信息
        }
        return "";
    }

}
