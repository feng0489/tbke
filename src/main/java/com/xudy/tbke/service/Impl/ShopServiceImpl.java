package com.xudy.tbke.service.Impl;


import com.xudy.tbke.dao.ShopDao;
import com.xudy.tbke.mapper.ShopMapper;
import com.xudy.tbke.model.Shop;
import com.xudy.tbke.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    @Autowired
    ShopMapper shopMapper;

    @Override
    public List<Map<String, Object>> listShop() {
        return shopMapper.selectAll();
    }

    @Override
    public int insertShop(Shop shop) {
        return shopMapper.insert(shop);
    }

    @Override
    public Shop findShopById(int id) {
        return shopMapper.selectById(id);
    }

    @Override
    public List<Shop> findShopByStartTime(String startTime) {
        return shopMapper.selectByStartTime(startTime);
    }

    @Override
    public int findLaseStartTime(String startTime,String itmeId) {
       return shopMapper.selectLastStartTime(startTime,itmeId);
    }
}
