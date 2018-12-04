package com.xudy.tbke.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共包类
 */
public class Common {

    /**
     * 将时间转为时间戳,或者时间戳转为时间
     * @param s  String 时间(戳)
     * @param stamp  Boolean ture为时间转为时间戳,fase时间戳转为时间
     * @return
     */
    public  String dateToStamp(String s,Boolean stamp){
        if(s=="" ||s== null){
            return "";
        }
        try{
            if(stamp){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = simpleDateFormat.parse(s);
                long ts = date.getTime() / 1000;
                return String.valueOf(ts);
            }else{
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long lt = new Long(s);
                Date date = new Date(lt*1000);
                return simpleDateFormat.format(date);
            }
        }catch(Exception e){
           Common con = new Common();
            con.sendLogger("时间转为时间戳异常："+e);
            e.printStackTrace();            //打印完整的异常信息
        }
        return "";
    }

    public  String getNow(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date());
    }

    public void sendLogger(String s){
         Logger logger = LoggerFactory.getLogger(getClass());
         Common con = new Common();
        logger.info("异常："+s+"   时间：" + con.getNow());
    }


    public static void main(String[] args) {
        Common con = new Common();
        System.out.println(con.dateToStamp("2018-12-03 18:22:49",true));//1543890169 时间转为时间戳
        System.out.println(con.dateToStamp("1543890169",false));//2018-12-03 18:22:49 时间戳转为时间
    }



}
