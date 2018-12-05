package com.xudy.tbke.mapper;

import com.xudy.tbke.model.TradeLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TradeLogMapper {

    public List<TradeLog> selectAll();

    public List<TradeLog> selectById();

    public List<TradeLog> selectByPage(Map<String,Object> map);

    public int insertOne(TradeLog tradeLog);

    public int insertMore(List<TradeLog> list);

    public int getTotals();

}
