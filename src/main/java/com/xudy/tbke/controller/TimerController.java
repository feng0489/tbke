package com.xudy.tbke.controller;


import com.google.gson.*;
import com.xudy.tbke.config.Common;
import com.xudy.tbke.config.HttpUtils;
import com.xudy.tbke.model.Shop;
import com.xudy.tbke.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
@EnableScheduling
public class TimerController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    ShopService shopService;
    /**
     * 每间隔10秒输出时间
     *
     * 定时器
     */
    @Scheduled(fixedRate = 10000)
    private void logTime(){
        logger.info("定时任务，现在时间："+System.currentTimeMillis());

    }
    @Scheduled(fixedRate = 10000)
    private void addShop(){
        long time1=System.currentTimeMillis();
        Common con = new Common();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("pid", "mm_29947720_14832832_57874820");
        parameters.put("category", "16,50006843");
        parameters.put("queryCount", "500");
        String result = HttpUtils.httpGet("http://uland.taobao.com/cp/coupon_list", parameters);

        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            JsonObject json = (JsonObject) parse.parse(result);

            boolean success = json.get("success").getAsBoolean();
            JsonObject jsobject = json.get("result").getAsJsonObject();
            JsonArray jsarr = jsobject.get("couponList").getAsJsonArray();

            if(!success || jsarr.isJsonNull()){
                con.sendLogger("获取优惠卷商户列表异常："+json.get("message").toString());
            }

            for(int i=0;i<jsarr.size();i++){
                Shop shop = new Shop();
                JsonObject subObject=jsarr.get(i).getAsJsonObject();
                JsonObject item = subObject.get("item").getAsJsonObject();
                int  hasadd = shopService.findLaseStartTime(subObject.get("effectiveStartTime").getAsString(),item.get("itemId").getAsString());

                System.out.println("计数总数----------------------------："+hasadd);
                if(hasadd==0){
                    shop.setTotalPrice(item.get("reservePrice").getAsFloat());
                    shop.setFreePrice(item.get("discountPrice").getAsFloat());
                    float price = item.get("reservePrice").getAsFloat()-item.get("discountPrice").getAsFloat();
                    shop.setPrice(price);
                    shop.setCommissionRate(subObject.get("startFee").getAsFloat());
                    shop.setCouponTotalCount(subObject.get("amount").getAsInt());
                    shop.setCouponInfo(subObject.get("startFee").getAsFloat());
                    shop.setCouponRemainCount(subObject.get("amount").getAsInt());
                    shop.setCouponClickUrl("http:"+item.get("clickUrl").getAsString());
                    shop.setPhotoUrl("http:"+item.get("picUrl").getAsString());
                    shop.setShopTitle(item.get("title").getAsString());
                    shop.setShopNick(subObject.get("shopName").getAsString());
                    shop.setItemDescription("");
                    shop.setShopId(item.get("itemId").getAsString());
                    shop.setShopFrom("");
                    shop.setFreeStartTime(con.dateToStamp(subObject.get("effectiveStartTime").getAsString(),true));
                    shop.setFreeEndTime(con.dateToStamp(subObject.get("effectiveEndTime").getAsString(),true));
                    shop.setGoodsSum(subObject.get("amount").getAsInt());
                    shop.setShopType( subObject.get("retStatus").getAsInt());
                    shop.setRetStatus(subObject.get("retStatus").getAsInt());
                    shop.setItemId(item.get("itemId").getAsString());
                    shop.setLensId(item.get("lensId").getAsString());
                    shop.setCouponKey(subObject.get("couponKey").getAsString());
                    shopService.insertShop(shop);
                }
            }
            long time2=System.currentTimeMillis();
            System.out.println("当前程序耗时："+(time2-time1)+"ms");
        }catch (JsonParseException jse){
            con.sendLogger("获取优惠卷商户列表出现错误："+jse);
            jse.printStackTrace();
        }
//        Gson gson = new Gson();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map = gson.fromJson(result, map.getClass());
//        Map<String, Object> couponList = (Map<String, Object>) map.get("result");
//        ArrayList<Object> maparray = (ArrayList<Object>) couponList.get("couponList");
//        Map<Integer,Object> shops = new HashMap<Integer, Object>();
//        Iterator<Object> iter = maparray.iterator();
//
//        int i=0;
//        while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
//            shops.put(i,iter.next());
//            i++;
//        }
//        Shop shop = new Shop();
//        for (Integer key : shops.keySet()) {
//            //System.out.println("Key = " + shops.get(key)+"\n");
//            Map<String, Object> shopt = (Map<String, Object>) shops.get(key);
//            Map<String, Object> item = (Map<String, Object>) shopt.get("item");
//            shop.setTotalPrice(Float.parseFloat((String)item.get("reservePrice")));
//            shop.setFreePrice(Float.parseFloat((String)item.get("discountPrice")));
//            float price = Float.parseFloat((String)item.get("reservePrice"))-Float.parseFloat((String)item.get("discountPrice"));
//            shop.setPrice(price);
//            shop.setCommissionRate(Float.parseFloat((String)shopt.get("startFee")));
//            shop.setCouponTotalCount( shopt.get("amount")=="" ? 0 : Integer.valueOf((String)shopt.get("amount")) );
//            shop.setCouponInfo(Float.parseFloat((String)item.get("discountPrice")));
//            shop.setCouponRemainCount(shopt.get("amount")=="" ? 0 : Integer.valueOf((String)shopt.get("amount")));
//            shop.setCouponClickUrl((String)item.get("http:"+"clickUrl"));
//            shop.setPhotoUrl((String)item.get("http:"+"picUrl"));
//            shop.setShopTitle((String)item.get("title"));
//            shop.setShopNick((String)shopt.get("shopName"));
//            shop.setItemDescription((String)item.get(""));
//            shop.setShopId((String)item.get(""));
//            shop.setShopFrom((String)item.get(""));
//            //shop.setFreeStartTime( Common.dateToStamp((String)shopt.get("effectiveStartTime")));
//           // shop.setFreeEndTime( Common.dateToStamp((String)shopt.get("effectiveEndTime")));
//            shop.setGoodsSum(shopt.get("amount")=="" ? 0 : Integer.valueOf((String)shopt.get("amount")));
//            shop.setShopType( shopt.get("retStatus")=="0" ? 0 : 0);
//            shop.setRetStatus( shopt.get("retStatus")=="0" ? 0 : 0);
//            shop.setItemId( String.valueOf(item.get("itemId")));
//            shop.setLensId(String.valueOf(item.get("itemId")));
//            shop.setCouponKey((String)shopt.get("couponKey"));
//            shopService.insertShop(shop);
//
//        }
//
//        long time2=System.currentTimeMillis();
//        System.out.println("当前程序耗时："+(time2-time1)+"ms");
    }


//    执行时间的配置
//    在上面的定时任务中，我们在方法上使用@Scheduled注解来设置任务的执行时间，并且使用三种属性配置方式：
//
//    fixedRate：定义一个按一定频率执行的定时任务
//    fixedDelay：定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合initialDelay， 定义该任务延迟执行时间。
//    cron：通过表达式来配置任务执行时间
//            cron表达式详解
//    一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。按顺序依次为：
//
//    秒（0~59）
//    分钟（0~59）
//            3 小时（0~23）
//            4 天（0~31）
//            5 月（0~11）
//            6 星期（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
//    年份（1970－2099）
//    其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。由于”月份中的日期”和”星期中的日期”这两个元素互斥的,必须要对其中一个设置。配置实例：
//
//    每隔5秒执行一次：/5 * * * ?
//    每隔1分钟执行一次：0 /1 * * ?
//            0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
//0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
//
//0 0 12 ? * WED 表示每个星期三中午12点
//
//“0 0 12 * * ?” 每天中午12点触发
//“0 15 10 ? * *” 每天上午10:15触发
//“0 15 10 * * ?” 每天上午10:15触发
//“0 15 10 * * ? *” 每天上午10:15触发
//“0 15 10 * * ? 2005” 2005年的每天上午10:15触发
//“0 * 14 * * ?” 在每天下午2点到下午2:59期间的每1分钟触发
//“0 0/5 14 * * ?” 在每天下午2点到下午2:55期间的每5分钟触发
//“0 0/5 14,18 * * ?” 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
//“0 0-5 14 * * ?” 在每天下午2点到下午2:05期间的每1分钟触发
//“0 10,44 14 ? 3 WED” 每年三月的星期三的下午2:10和2:44触发
//“0 15 10 ? * MON-FRI” 周一至周五的上午10:15触发
//“0 15 10 15 * ?” 每月15日上午10:15触发
//“0 15 10 L * ?” 每月最后一日的上午10:15触发
//“0 15 10 ? * 6L” 每月的最后一个星期五上午10:15触发
//“0 15 10 ? * 6L 2002-2005” 2002年至2005年的每月的最后一个星期五上午10:15触发
//“0 15 10 ? * 6#3” 每月的第三个星期五上午10:15触发



//        public static void main(String[] args){
//            String str =  "1541299560";
//            String str1 = "1543891560";
//            if((Integer.parseInt(str)-Integer.parseInt(str1))<0){
//                System.out.println(111);
//            }else{
//                System.out.println(222);
//            }
//        }



}
