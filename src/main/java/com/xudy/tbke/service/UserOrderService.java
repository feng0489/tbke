package com.xudy.tbke.service;

import com.xudy.tbke.model.UserOrder;

import java.util.List;
import java.util.Map;

public interface UserOrderService {

    public List<Map<String,Object>> selectAll();

    public List<UserOrder> selectById(Integer id);

    public List<UserOrder> selectByPage(Map<String,Object> map);

    public int getTotal();

    public int insertOne(UserOrder userGrade);

    public int insertMore(List<UserOrder> list);
}
