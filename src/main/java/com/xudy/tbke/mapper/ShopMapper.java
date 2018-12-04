package com.xudy.tbke.mapper;


import com.xudy.tbke.model.Shop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShopMapper {

    @Select("select * from shop")
    List<Map<String,Object>> selectAll();

    @Insert("INSERT INTO shop(total_price, free_price, price, commission_rate, coupon_total_count, coupon_info, coupon_remain_count, coupon_click_url, photo_url, shop_title, shop_nick, item_description, shop_id, title, shop_from, free_start_time, free_end_time, goods_sum, shop_type,retStatus,itemId,lensId,couponKey) " +
                          "VALUES (#{totalPrice}, #{freePrice}, #{price},  #{commissionRate}, #{couponTotalCount}, #{couponInfo}, #{couponRemainCount}, #{couponClickUrl}, #{photoUrl}, #{shopTitle}, #{shopNick}, #{itemDescription}, #{shopId}, #{title}, #{shopFrom}, #{freeStartTime}, #{freeEndTime}, #{goodsSum}, #{shopType},#{retStatus},#{itemId},#{lensId},#{couponKey});")
    int insert(Shop shop);

    @Select("select free_start_time from shop where free_start_time = #{freeStartTime}")
    List<Shop> selectByStartTime(String freeStartTime);

    @Select("select count(id) as count from shop where free_start_time=#{freeStartTime} and itemId=#{itmeId} ")
    int selectLastStartTime(@Param("freeStartTime") String freeStartTime, @Param("itmeId") String itmeId);

    @Select("select * from shop where id=#{id}")
    Shop selectById(int id);


}
