package com.xudy.tbke.service.Impl;

import com.xudy.tbke.dao.TradeLogDao;
import com.xudy.tbke.mapper.TradeLogMapper;
import com.xudy.tbke.model.TradeLog;
import com.xudy.tbke.service.TradeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TradeLogServiceImpl implements TradeLogService {

    @Autowired
    private TradeLogMapper tradeLogMapper;

    @Autowired
    private TradeLogDao tradeLogDao;

    @Override
    public List<Map<String,Object>> selectAll() {
        return tradeLogMapper.selectAll();
    }

    @Override
    public List<TradeLog> selectById(Integer id) {
        return tradeLogMapper.selectById(id);
    }

    @Override
    public List<TradeLog> selectByPage(Map<String, Object> map) {
        return tradeLogMapper.selectByPage(map);
    }

    @Override
    public int getTotal() {
        return tradeLogMapper.getTotals();
    }

    @Override
    public int insertOne(TradeLog tradeLog) {
        return tradeLogMapper.insertOne(tradeLog);
    }

    @Override
    public int insertMore(List<TradeLog> list) {
        return tradeLogMapper.insertMore(list);
    }
}
