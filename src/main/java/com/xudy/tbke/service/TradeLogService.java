package com.xudy.tbke.service;

import com.xudy.tbke.model.TradeLog;

import java.util.List;
import java.util.Map;

public interface TradeLogService {

    public List<Map<String,Object>> selectAll();

    public List<TradeLog> selectById(Integer id);

    public List<TradeLog> selectByPage(Map<String,Object> map);

    public int getTotal();

    public int insertOne(TradeLog tradeLog);

    public int insertMore(List<TradeLog> list);
}
