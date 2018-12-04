package com.xudy.tbke.service;


import com.xudy.tbke.model.Shop;

import java.util.List;
import java.util.Map;

public interface ShopService {

    List<Map<String,Object>> listShop();

    int insertShop(Shop shop);

    Shop findShopById(int id);

    List<Shop> findShopByStartTime(String startTime);

    int findLaseStartTime(String startTime,String itmeId);


}
