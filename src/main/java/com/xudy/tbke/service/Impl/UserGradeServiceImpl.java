package com.xudy.tbke.service.Impl;

import com.xudy.tbke.dao.UserGradeDao;
import com.xudy.tbke.mapper.UserGradeMapper;
import com.xudy.tbke.model.UserGrade;
import com.xudy.tbke.service.UserGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserGradeServiceImpl implements UserGradeService {

    @Autowired
    private UserGradeDao userGradeDao;

    @Autowired
    private UserGradeMapper userGradeMapper;

    @Override
    public List<Map<String, Object>> selectAll() {
        return userGradeMapper.selectAll();
    }

    @Override
    public List<UserGrade> selectById(Integer id) {
        return userGradeMapper.selectById(id);
    }

    @Override
    public List<UserGrade> selectByPage(Map<String, Object> map) {
        return userGradeMapper.selectByPage(map);
    }

    @Override
    public int getTotal() {
        return userGradeMapper.getTotals();
    }

    @Override
    public int insertOne(UserGrade userGrade) {
        return userGradeMapper.insertOne(userGrade);
    }

    @Override
    public int insertMore(List<UserGrade> list) {
        return userGradeMapper.insertMore(list);
    }
}
