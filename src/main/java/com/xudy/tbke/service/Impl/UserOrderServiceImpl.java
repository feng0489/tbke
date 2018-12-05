package com.xudy.tbke.service.Impl;

import com.xudy.tbke.dao.UserOrderDao;
import com.xudy.tbke.mapper.UserOrderMapper;
import com.xudy.tbke.model.UserOrder;
import com.xudy.tbke.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderDao userOrderDao;

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public List<Map<String, Object>> selectAll() {
        return userOrderMapper.selectAll();
    }

    @Override
    public List<UserOrder> selectById(Integer id) {
        return userOrderMapper.selectById(id);
    }

    @Override
    public List<UserOrder> selectByPage(Map<String, Object> map) {
        return userOrderMapper.selectByPage(map);
    }

    @Override
    public int getTotal() {
        return userOrderMapper.getTotals();
    }

    @Override
    public int insertOne(UserOrder userGrade) {
        return userOrderMapper.insertOne(userGrade);
    }

    @Override
    public int insertMore(List<UserOrder> list) {
        return userOrderMapper.insertMore(list);
    }
}
