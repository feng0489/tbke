package com.xudy.tbke.mapper;

import com.xudy.tbke.model.User;
import com.xudy.tbke.model.UserOrder;

import java.util.List;
import java.util.Map;

public interface UserOrderMapper {

    public List<Map<String,Object>> selectAll();

    public List<UserOrder> selectById(Integer id);

    public List<UserOrder> selectByPage(Map<String,Object> map);

    public int insertOne(UserOrder userOrder);

    public int insertMore(List<UserOrder> list);

    public int getTotals();
}
